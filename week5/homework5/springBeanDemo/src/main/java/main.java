
import bean.Userbean;
import util.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {
    public static void main(String[] args) {
/*
        // 定义配置文件路径
        String xmlPath = "./UserBean.xml";
        // 加载配置文件
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(xmlPath);
        User userXml =
                (User) applicationContext.getBean("userXml");
        System.out.println(userXml);
*/


        AnnotationConfigApplicationContext configApplicationContext  =new AnnotationConfigApplicationContext(Userbean.class);
        User user = (User)configApplicationContext.getBean("user");

        System.out.println(user);


    }
}
