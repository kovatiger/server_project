package app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "flight_id")
    private Long flightId;
    @Setter
    @ManyToOne
    @JoinColumn(name = "way_id")
    private Way wayId;
    @Setter
    @OneToMany(mappedBy = "flightId")
    private List<Trip> tripList;
    @Setter
    @Column(name = "price")
    private Long price;
    @Setter
    @ManyToOne
    @JoinColumn(name = "time_id")
    private Time timeId;
}