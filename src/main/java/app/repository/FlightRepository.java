package app.repository;

import app.entity.Flight;
import app.entity.Time;
import app.entity.Way;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface FlightRepository extends JpaRepository<Flight,Long> {
    @Query("from Flight group by wayId")
    List<Flight> findAllPopularFlights();

    Flight findByTimeIdAndWayId(Time timeId, Way wayId);
}
