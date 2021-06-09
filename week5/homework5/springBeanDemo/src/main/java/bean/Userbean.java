package bean;


import util.entity.User;
import org.springframework.context.annotation.Bean;

public class Userbean {
    @Bean
    public User user(){
        return new User("林俊杰","男");
    }
}
