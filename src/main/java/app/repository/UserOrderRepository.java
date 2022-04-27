package app.repository;

import app.entity.User;
import app.entity.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {
    List<UserOrder> findByUserId(User user);
}
