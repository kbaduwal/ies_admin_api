package kb.baduwal.bindings;

import lombok.Data;


public class UnlockAccForm {
    private String email;
    private String tempPwd;
    private String newPwd;
    private String confirmPwd;

    public UnlockAccForm(String email, String tempPwd, String newPwd, String confirmPwd) {
        this.email = email;
        this.tempPwd = tempPwd;
        this.newPwd = newPwd;
        this.confirmPwd = confirmPwd;
    }
}
