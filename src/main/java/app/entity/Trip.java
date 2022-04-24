package app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trip_id")
    private Long tripId;
    @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flight_id")
    private Flight flightId;
    @Setter
    @OneToMany(mappedBy = "tripId")
    private List<UserOrder> orderList;
    @Setter
    @Column(name = "date_of_trip")
    private String dateOfTrip;
    @Setter
    @Column(name = "place")
    private Integer place;
}