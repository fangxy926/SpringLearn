import com.example.cycleReference.A;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {


    @Test
    public void cycleRefTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("cycleRefTest.xml");
        A a = (A) context.getBean("A");
        a.methodA();
    }

}
