import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import quickStart.dao.PersonDao;

public class BeanInjectionTest {
    @Test
    public void testValue(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonDao p = (PersonDao)app.getBean("personDao");
        p.save();
    }
}
