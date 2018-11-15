import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author guofa.liu
 * @create 2018/11/15 14:38
 * @description
 */

@SpringBootApplication(scanBasePackages = {"service", "mapper", "controller"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
