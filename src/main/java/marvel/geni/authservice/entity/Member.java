package marvel.geni.authservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import marvel.geni.authservice.constant.Gender;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "member", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(generator = "uuid2")
    //@GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(name="memberId", updatable = false)
    private Long memberId;

    @Column(name="email")
    @NotNull
    private String email;

    @Column(name="password")
    @NotNull
    private String password;

    @Column(name="name")
    @NotNull
    private String name;

    @Column(name="gender")
    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name="age")
    @NotNull
    private Integer age;

    @Column(name="kg")
    @NotNull
    private Float kg;

    @Column(name="cm")
    @NotNull
    private Float cm;

    @Column(name="registeredDate", updatable = false)
    @CreatedDate
    private LocalDateTime registeredDate;

    @Column(name="updateDate", updatable = true)
    @LastModifiedDate
    private LocalDateTime updateDate;

}
