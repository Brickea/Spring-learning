import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import quickStart.dao.PersonDao;

public class ScopeTest {

    @Test
    // 测试scope属性
    public void testScope(){
        // 测试scope返还的对象地址是否一致
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonDao p1 = (PersonDao) app.getBean("personDao");
        PersonDao p2 = (PersonDao) app.getBean("personDao");

        System.out.println("p1"+p1);
        System.out.println("p2"+p2);

    }

    @Test
    public void testInitDestroy(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonDao p = (PersonDao) app.getBean("personDao");
        p.save();

        // 手动关闭
        ((ClassPathXmlApplicationContext)app).close();
    }
}
