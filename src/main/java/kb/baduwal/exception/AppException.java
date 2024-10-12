package kb.baduwal.exception;

import java.time.LocalDate;

public class AppException {

    private String exCode;

    private String exDesc;

    private LocalDate exDate;

    public String getExCode() {
        return exCode;
    }

    public void setExCode(String exCode) {
        this.exCode = exCode;
    }

    public String getExDesc() {
        return exDesc;
    }

    public void setExDesc(String exDesc) {
        this.exDesc = exDesc;
    }

    public LocalDate getExDate() {
        return exDate;
    }

    public void setExDate(LocalDate exDate) {
        this.exDate = exDate;
    }
}
