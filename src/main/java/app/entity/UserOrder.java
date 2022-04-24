package app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "user_order")
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long orderId;
    @Setter
    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip tripId;
    @Setter
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User userId;
    @Setter
    @Column(name = "place")
    private Integer place;
}