package test;

import domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Project: IntelliJ IDEA
 * @Author: Zixiao Wang
 * @Description:
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCURDTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testInsert(){
        jdbcTemplate.update("insert into account values(?,?)","test",12312312);
    }
    @Test
    public void testUpdate(){
        jdbcTemplate.update("update account set money=? where name=?",666,"brickea");
    }
    @Test
    public void testDelete(){
        jdbcTemplate.update("delete from account where name=?","test");
    }

    @Test
    public void testQuery(){
        List<Account> accounts = jdbcTemplate.query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(accounts);
    }
    @Test
    public void testQueryForObject(){
        Account account = jdbcTemplate.queryForObject("select * from account where name=?",new BeanPropertyRowMapper<Account>(Account.class),"brickea");
        System.out.println(account);
    }
    @Test
    public void testQueryCount(){

        long count = jdbcTemplate.queryForObject("select count(*) from account",Long.class);
        System.out.println(count);
    }
}
