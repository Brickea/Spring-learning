import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import quickStart.service.PersonService;

public class ApplicationContextTest {
    @Test
    public void ApplicationContextDifferentTest() {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 使用绝对路径获取应用上下文
        ApplicationContext app = new FileSystemXmlApplicationContext("G:\\Code\\Spring-learning\\Spring quick start\\src\\main\\resources\\applicationContext.xml");
        PersonService pS = (PersonService) app.getBean("personService");
        pS.save();

    }
}
