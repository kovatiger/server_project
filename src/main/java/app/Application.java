package app;

import app.entity.Role;
import app.entity.Status;
import app.entity.User;
import app.entity.UserInfo;
import app.service.user_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner commandLineRunner(@Autowired UserService userService) {
        return args -> {
            if (userService.findUserByLogin("ADMIN") == null) {
                User user = new User();
                user.setLogin("ADMIN");
                user.setPassword("ADMINadmin1");
                UserInfo userInfo = new UserInfo();
                userInfo.setMobileNumber("+3752911111111");
                user.setUserInfoId(userInfo);
                Role role = new Role();
                role.setRoleName("ADMIN");
                Status status = new Status();
                status.setStatusName("ACTIVE");
                userService.saveUser(user, role, status);
            }
        };
    }
}
