package app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "way")
public class Way {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "way_id")
    private Long wayId;
    @Setter
    @OneToMany(mappedBy = "wayId")
    private List<Flight> waysList;
    @Setter
    @Column(name = "way")
    private String way;
}