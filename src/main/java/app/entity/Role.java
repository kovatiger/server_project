package app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;
    @Setter
    @OneToMany(mappedBy = "role")
    @Column(name = "role", nullable = false)
    private List<User> usersRoleList;
    @Setter
    @Column(name = "role_name", unique = true)
    private String roleName;
}
