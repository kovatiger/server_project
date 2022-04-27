package app.repository;

import app.entity.Way;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WayRepository extends JpaRepository<Way,Long> {
    Way findByWay(String way);
}
