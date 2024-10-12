package kb.baduwal.service;

import kb.baduwal.bindings.DashboardCard;
import kb.baduwal.bindings.LoginForm;

public interface UserService {

     public String login(LoginForm loginForm);

     public boolean recoverPwd(String email);

     public DashboardCard fetchDashboardInfo();
}
