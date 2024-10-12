package kb.baduwal.rest;

import kb.baduwal.bindings.DashboardCard;
import kb.baduwal.bindings.LoginForm;
import kb.baduwal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody LoginForm loginForm){
        String status = userService.login(loginForm);

        if(status.equals("Success")){
            return "redirect:/dashboard";
        }else {
            return status;
        }

    }

    @GetMapping("/dashboard")
    public ResponseEntity<DashboardCard> buildDashBoard(){
        DashboardCard dashboardCard = userService.fetchDashboardInfo();

        return new ResponseEntity<>(dashboardCard, HttpStatus.OK);
    }



}
