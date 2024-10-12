package kb.baduwal.service;

import kb.baduwal.bindings.DashboardCard;
import kb.baduwal.bindings.LoginForm;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public String login(LoginForm loginForm) {
        return "";
    }

    @Override
    public boolean recoverPwd(String email) {
        return false;
    }

    @Override
    public DashboardCard fetchDashboardInfo() {
        return null;
    }
}
