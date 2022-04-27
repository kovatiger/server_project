package app.repository;

import app.entity.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends JpaRepository<Time,Long> {
    Time findByTime(String time);
}
