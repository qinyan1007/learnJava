package util.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import util.entity.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(util.entity.User.class)
public class UserConfig {
    @Bean
    @ConditionalOnMissingBean(User.class)
    public User getUser(){
        User user = new User();
        user.setUserName("许嵩");
        user.setSex("男");
        return user;
    }
}
