package kb.baduwal.service;


import kb.baduwal.bindings.UnlockAccForm;
import kb.baduwal.bindings.UserAccountForm;

import java.util.List;

public interface AccountService {

    public boolean createUSerAccount(UserAccountForm accForm);

    public List<UserAccountForm> fetchUserAccounts();

    public UserAccountForm getUserAccById(Integer accId);

    public String changeAccStatus(Integer accId, String status);

    public String unlockUserAccount(UnlockAccForm unlockAccForm);
}
