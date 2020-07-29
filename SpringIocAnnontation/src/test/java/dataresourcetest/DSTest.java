package dataresourcetest;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springicoanno.config.SpringConfiguration;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DSTest {

    @Test
    // 测试手动创建 c3p0 数据源
    public void C3p0ConnectionTest() throws Exception{
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        // 加载驱动
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver"); // 8.0之后使用这个驱动
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC");
        dataSource.setUser("root");
        dataSource.setPassword("fjwwzx970814");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    // 测试手动创建 druid 数据源
    public void DruidConnectionTest() throws Exception{
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("fjwwzx970814");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    // 配置抽取
    // 测试手动创建 c3p0 数据源，通过jdbc.properties文件读取配置
    // 这样的好处是当打包之后，如果直接配置的话只能看到字节码文件，不好修改配置，但是配置文件打完包之后也是跟开发阶段是一样的，可以直接进行修改，更方便
    public void C3p0ConnectionFromPropTest() throws Exception{
        // 读取配置文件
        ResourceBundle rb = ResourceBundle.getBundle("jdbc"); // 该路径是基于resource
        String driver = rb.getString("jdbc.driver");
        String url = rb.getString("jdbc.url");
        String username = rb.getString("jdbc.username");
        String password = rb.getString("jdbc.password");

        // 设置连接源
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    // 通过 Spring 获取bean来创建连接
    public void C3p0ConnectionByBeanTest() throws Exception{
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        ComboPooledDataSource dataSource = app.getBean(ComboPooledDataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();

    }

    @Test
    public void C3p0ConnectionBySpringConfigClass() throws SQLException {
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        ComboPooledDataSource dataSource = app.getBean(ComboPooledDataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
