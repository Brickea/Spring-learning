package springicoanno.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.SQLException;


public class DataSourceConfiguration {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean("dataSource") // 会将当前方法的返回值以指定名称存入容器
    public DataSource getDataSource() throws SQLException, PropertyVetoException {
//        配置第三方类
//      <bean id="mysqlComboPoolDS" class="com.mchange.v2.c3p0.ComboPooledDataSource">
//        <!--        这里使用SpEL来获取properties文件中的变量-->
//        <property name="driverClass" value="${jdbc.driver}"/>
//        <property name="jdbcUrl"
//        value="${jdbc.url}"/>
//        <property name="user" value="${jdbc.username}"/>
//        <property name="password" value="${jdbc.password}"/>
//      </bean>
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(this.driver);
        dataSource.setJdbcUrl(this.url);
        dataSource.setUser(this.username);
        dataSource.setPassword(this.password);
        return dataSource;
    }
}
