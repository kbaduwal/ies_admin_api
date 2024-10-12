package kb.baduwal.service;

import kb.baduwal.bindings.UnlockAccForm;
import kb.baduwal.bindings.UserAccountForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{
    @Override
    public boolean createUSerAccount(UserAccountForm accForm) {
        return false;
    }

    @Override
    public List<UserAccountForm> fetchUserAccounts() {
        return List.of();
    }

    @Override
    public UserAccountForm getUserAccById(Integer accId) {
        return null;
    }

    @Override
    public String changeAccStatus(Integer accId, String status) {
        return "";
    }

    @Override
    public String unlockUserAccount(UnlockAccForm unlockAccForm) {
        return "";
    }
}
