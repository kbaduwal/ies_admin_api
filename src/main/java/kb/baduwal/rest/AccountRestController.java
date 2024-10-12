package kb.baduwal.rest;

import kb.baduwal.bindings.UserAccountForm;
import kb.baduwal.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountRestController {

    @Autowired
    private AccountService accService;

    //To create the user account / To insert the record
    @PostMapping("/user")
    public ResponseEntity<String> createAccount(@RequestBody UserAccountForm userAcctForm){

        boolean status = accService.createUSerAccount(userAcctForm);

        if(status){
            return new ResponseEntity<>("Account Created", HttpStatus.CREATED);//201
        }else {
            return new ResponseEntity<>("Account Created Failed", HttpStatus.INTERNAL_SERVER_ERROR);//500
        }

    }

    //To retrieve all the users account
    @GetMapping("/users")
    public ResponseEntity<List<UserAccountForm>> getUSer(){
        List<UserAccountForm> userAccForms = accService.fetchUserAccounts();

        return new ResponseEntity<>(userAccForms,HttpStatus.OK);
    }

    //Get the user with the userId [Mainly used for editing mode]
    @GetMapping("/user/{userId}")
    public ResponseEntity<UserAccountForm> getUser(@PathVariable("userId") Integer userId){

        UserAccountForm userAccById = accService.getUserAccById(userId);

        return new ResponseEntity<>(userAccById, HttpStatus.OK);
    }

    //Update the user account/To update the records
    @PutMapping("/user/{userId}/{status}")
    public ResponseEntity<List<UserAccountForm>> updateUserAcc(@PathVariable("userId") Integer userId, @PathVariable("status") String status){

        accService.changeAccStatus(userId, status);

        List<UserAccountForm> userAccForms = accService.fetchUserAccounts();

        return new ResponseEntity<>(userAccForms,HttpStatus.OK);
    }



}
