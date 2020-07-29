package springwithjunit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springicoanno.config.SpringConfiguration;
import springicoanno.service.PersonService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class) // 提供一个测试内核
//@ContextConfiguration("classpath:applicationContext.xml") // 指定配置文件
@ContextConfiguration(classes = {SpringConfiguration.class})
public class SpringTest {
    // 这样可以避免反复写 ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);

    @Autowired
    private PersonService personService;

    @Autowired
    private DataSource dataSource;

    @Test
    public  void personServiceTest(){
        this.personService.save();
    }

    @Test
    public void dataSourceTest() throws SQLException {
        Connection connection =  this.dataSource.getConnection();
        System.out.println(connection);
    }
}
