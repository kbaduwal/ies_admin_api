package kb.baduwal.rest;

import kb.baduwal.bindings.UserAccountForm;
import kb.baduwal.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountRestController {

    private Logger logger = LoggerFactory.getLogger(AccountRestController.class);

    @Autowired
    private AccountService accService;

    //To create the user account / To insert the record
    @PostMapping("/user")
    public ResponseEntity<String> createAccount(@RequestBody UserAccountForm userAcctForm){

        logger.debug("Account creation process started...");

        boolean status = accService.createUSerAccount(userAcctForm);

        logger.debug("Account creation process completed...");


        if(status){
            logger.info("Account created Successfully...");
            return new ResponseEntity<>("Account Created", HttpStatus.CREATED);//201
        }else {
            logger.info("Account created Failed...");
            return new ResponseEntity<>("Account Created Failed", HttpStatus.INTERNAL_SERVER_ERROR);//500
        }

    }

    //To retrieve all the users account
    @GetMapping("/users")
    public ResponseEntity<List<UserAccountForm>> getUSer(){
        logger.debug("Fetching user account process started...");
        List<UserAccountForm> userAccForms = accService.fetchUserAccounts();
        logger.debug("Fetching user account process completed...");
        logger.info("User Account Fetched Success...");
        return new ResponseEntity<>(userAccForms,HttpStatus.OK);
    }

    //Get the user with the userId [Mainly used for editing mode]
    @GetMapping("/user/{userId}")
    public ResponseEntity<UserAccountForm> getUser(@PathVariable("userId") Integer userId){
        UserAccountForm userAccById = accService.getUserAccById(userId);
        logger.info("User account fetched successfully...");
        return new ResponseEntity<>(userAccById, HttpStatus.OK);
    }

    //Update the user account/To update the records
    @PutMapping("/user/{userId}/{status}")
    public ResponseEntity<List<UserAccountForm>> updateUserAcc(@PathVariable("userId") Integer userId,
                                                               @PathVariable("status") String status){
        logger.debug("User account update process started...");
        accService.changeAccStatus(userId, status);
        logger.debug("User account update process complete...");
        logger.info("User account status updated successfully...");
        List<UserAccountForm> userAccForms = accService.fetchUserAccounts();
        return new ResponseEntity<>(userAccForms,HttpStatus.OK);
    }



}
