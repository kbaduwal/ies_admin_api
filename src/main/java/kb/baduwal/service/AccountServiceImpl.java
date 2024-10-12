package kb.baduwal.service;

import kb.baduwal.bindings.UnlockAccForm;
import kb.baduwal.bindings.UserAccountForm;
import kb.baduwal.entities.UserEntity;
import kb.baduwal.repositories.UserRepo;
import kb.baduwal.utils.EmailUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private EmailUtils emailUtils;


    @Override
    public boolean createUSerAccount(UserAccountForm accForm) {
        UserEntity entity = new UserEntity();
        BeanUtils.copyProperties(accForm,entity); //Copy the data from binding class to userEntity class, [source= accForm object] ->[target= entity object]

        //Set Random Password
        entity.setPwd(generatePwd());

        //Set Account status
        entity.setAccStatus("LOCKED");
        entity.setActiveSw("Y");

        userRepo.save(entity);

        //Send email
        String subject ="";
        String body = "";

        return emailUtils.sendEmail(subject,body,accForm.getEmail());
    }

    @Override
    public List<UserAccountForm> fetchUserAccounts() {

        //1.Retrieving all the record from the table
        List<UserEntity> userEntities = userRepo.findAll();

        //Convert each entities into one binding object and store into binding object
        List<UserAccountForm> users = new ArrayList<UserAccountForm>();

        // 2. Convert each entities into one binding object
        for(UserEntity userEntity : userEntities){
            UserAccountForm user = new UserAccountForm();
            BeanUtils.copyProperties(userEntity, user);
            // 3.store into binding object
            users.add(user);
        }

        return users;
    }


    //This methods will help for data to come in editable format as per the id
    @Override
    public UserAccountForm getUserAccById(Integer accId) {

        Optional<UserEntity> optional = userRepo.findById(accId);

        if(optional.isPresent()){
            UserEntity userEntity = optional.get();
            UserAccountForm user = new UserAccountForm();
            BeanUtils.copyProperties(userEntity,user);
            return user;
        }

        return null;
    }

    @Override
    public String changeAccStatus(Integer userId, String status) {
        int cnt = userRepo.updateAccStatus(userId,status);

        if(cnt>0){
            return "status changed";
        }

        return "Failed to changed";
    }

    @Override
    public String unlockUserAccount(UnlockAccForm unlockAccForm) {
        UserEntity entity = userRepo.findByEmail(unlockAccForm.getEmail());

        entity.setPwd(unlockAccForm.getNewPwd());
        entity.setAccStatus("UNLOCKED");

        userRepo.save(entity);

        return "Account Unlocked";
    }

   private String generatePwd(){
       String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
       String numbers = "0123456789";

       // combine all strings
       String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;

       // create random string builder
       StringBuilder sb = new StringBuilder();

       // create an object of Random class
       Random random = new Random();

       // specify length of random string
       int length = 6;

       for(int i = 0; i < length; i++) {

           // generate random index number
           int index = random.nextInt(alphaNumeric.length());

           // get character specified by index
           // from the string
           char randomChar = alphaNumeric.charAt(index);

           // append the character to string builder
           sb.append(randomChar);
       }

       return sb.toString();
   }
}
