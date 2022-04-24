package app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "time")
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "time_id")
    private Long timeId;
    @Setter
    @OneToMany(mappedBy = "timeId")
    private List<Flight> timeList;
    @Setter
    @Column(name = "time")
    private String time;
}