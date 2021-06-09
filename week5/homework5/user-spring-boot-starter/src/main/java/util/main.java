package util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import util.config.UserConfig;

@SpringBootApplication
public class main {
    public static void main(String[] args) {
        SpringApplication.run(main.class, args);
    }
}
