package springicoanno.dao.impl;

import org.springframework.stereotype.Repository;
import springicoanno.dao.PersonDao;

// 代替<bean>配置
@Repository("personDao")
public class PersonDaoImpl implements PersonDao {
    public void save() {
        System.out.println("Save.....");
    }
}
