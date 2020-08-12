package test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

/**
 * @Project: IntelliJ IDEA
 * @Author: Zixiao Wang
 * @Description:
 **/

public class JdbcTemplateTest {

    /**
    * @author: Zixiao Wang
    * @date: 8/11/2020
    * @param: []
    * @return: void
    * @description:
     * 测试 JdbcTemplate 开发步骤
    **/
    @Test
    public void test1() throws PropertyVetoException {
        // 创建数据源对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC");
        dataSource.setUser("root");
        dataSource.setPassword("fjwwzx970814");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // 设置数据源对象，知道数据库在哪里
        jdbcTemplate.setDataSource(dataSource);
        // 执行操作
        jdbcTemplate.update("insert into account values(?,?)","brickea",5000);
    }

    /**
    * @author: Zixiao Wang
    * @date: 8/11/2020
    * @param: []
    * @return: void
    * @description:
     * 使用spring 容器
    **/
    @Test
    public void test2(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate");

        jdbcTemplate.update("insert into account values(?,?)","Sandy",10000);
    }
}
