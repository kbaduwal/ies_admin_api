package kb.baduwal.bindings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

//Don't write @Data annotation because if we write toString method will also come,
// for binding class toString  is fine but for entity if we use with relationship
// We will get the stack overflow error
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountForm {
    private String fullName;
    private String email;
    private Long mobileNo;
    private String gender;
    private LocalDate dob;
    private Long ssn;
    private String activeSw;
    private Integer roleId;
}
