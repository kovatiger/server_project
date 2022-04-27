package app.repository;

import app.entity.Flight;
import app.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TripRepository extends JpaRepository<Trip, Long> {
    Trip findByDateOfTripAndFlightId(String dateOfTRip, Flight flightId);

    @Query("update Trip set place =:place where flightId =:flight and dateOfTrip =:date")
    @Modifying
    void updateAmountOfPlaces(@Param("place") Integer place,@Param("flight") Flight flight,@Param("date") String date);
}
