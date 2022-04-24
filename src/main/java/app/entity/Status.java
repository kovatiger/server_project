package app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "status")
@Getter
@NoArgsConstructor
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private Long statusId;
    @Setter
    @OneToMany(mappedBy = "status")
    @Column(name = "status", nullable = false)
    private List<User> usersStatusList;
    @Setter
    @Column(name = "status_name")
    private String statusName;
}