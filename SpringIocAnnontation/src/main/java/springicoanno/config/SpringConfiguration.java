package springicoanno.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

// 标志该类是Spring的核心配置类
@Configuration
// <context:component-scan base-package="springicoanno"/>
@ComponentScan("springicoanno")
// <context:property-placeholder location="classpath:jdbc.properties"/>
@PropertySource("jdbc.properties")
//    注解加载其他配置类
//    <import resource="applicationContext-other.xml"/>-->
@Import({DataSourceConfiguration.class}) // 这里是个数组，如果引用多个，就用逗号隔开就可以了
public class SpringConfiguration {

//    有了import注解下面的就可以放到另外的配置类了
//    @Value("${jdbc.driver}")
//    private String driver;
//    @Value("${jdbc.url}")
//    private String url;
//    @Value("${jdbc.username}")
//    private String username;
//    @Value("${jdbc.password}")
//    private String password;
//
//    @Bean("dataSource") // 会将当前方法的返回值以指定名称存入容器
//    public DataSource getDataSource() throws SQLException, PropertyVetoException {
////        配置第三方类
////      <bean id="mysqlComboPoolDS" class="com.mchange.v2.c3p0.ComboPooledDataSource">
////        <!--        这里使用SpEL来获取properties文件中的变量-->
////        <property name="driverClass" value="${jdbc.driver}"/>
////        <property name="jdbcUrl"
////        value="${jdbc.url}"/>
////        <property name="user" value="${jdbc.username}"/>
////        <property name="password" value="${jdbc.password}"/>
////      </bean>
//        ComboPooledDataSource dataSource = new ComboPooledDataSource();
//        dataSource.setDriverClass(this.driver);
//        dataSource.setJdbcUrl(this.url);
//        dataSource.setUser(this.username);
//        dataSource.setPassword(this.password);
//        return dataSource;
//    }
}
