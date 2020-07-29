import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import quickStart.service.PersonService;

public class GetBeanTest {
    @Test
    public void DifferentGetBeanTest(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonService pS = app.getBean(PersonService.class); // 这里用的是字节码对象，不用强制转换，但是如果同种类友多个bean还是用id会比较好
    }
}
