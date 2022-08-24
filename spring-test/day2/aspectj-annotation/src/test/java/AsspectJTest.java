import com.oraclejava.day2.AppConfig;
import com.oraclejava.day2.Cat;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class AsspectJTest {
    @Test
    public void catTest() {
        GenericApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        Cat cat = ac.getBean(Cat.class);

        cat.setBreed("Russian Blue");
        String breed = cat.getBreed();
        System.out.println(breed);
        cat.speak();

        ac.close();
    }
}
