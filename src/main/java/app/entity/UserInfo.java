package app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users_info")
@NoArgsConstructor
@Getter
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_info_id")
    private Long userInfoId;
    @Column(nullable = false)
    @Setter
    private String mobileNumber;
    @OneToOne(mappedBy = "userInfoId")
    private User user;
}