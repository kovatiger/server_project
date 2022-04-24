package app.repository;

import app.entity.Status;
import app.entity.User;
import app.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByLogin(String login);

    @Query("update User set status =:status where login =:login")
    @Modifying
    void updateUserStatusByLogin(@Param("status") Status status, @Param("login") String login);

    @Query("update User set login =:login,password =:password,userInfoId =:mobileNumber where login =:oldLogin")
    @Modifying
    void updateUserByLogin(@Param("login") String login,
                           @Param("password") String password,
                           @Param("mobileNumber") UserInfo mobileNumber,
                           @Param("oldLogin") String oldLogin);

    @Query("from User where login =:login")
    User findUserInfoByUserLogin(@Param("login") String login);
}
