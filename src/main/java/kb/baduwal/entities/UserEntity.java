package kb.baduwal.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name="IES_USERS")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    private String fullName;
    private String email;
    private String pwd;
    private Long mobileNo;
    private String gender;
    private LocalDate dob;
    private Long ssn;
    private String accStatus;
    private String activeSw;

    private Integer roleId;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<PlanEntity> plans;
}
