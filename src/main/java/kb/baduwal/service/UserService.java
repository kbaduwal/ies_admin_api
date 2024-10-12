package kb.baduwal.service;

import kb.baduwal.bindings.DashboardCard;
import kb.baduwal.bindings.LoginForm;
import kb.baduwal.bindings.UserAccountForm;

public interface UserService {

     public String login(LoginForm loginForm);

     public boolean recoverPwd(String email);

     public DashboardCard fetchDashboardInfo();

     public UserAccountForm getUserByEmail(String email);
}
