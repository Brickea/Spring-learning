package DaoDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import quickStart.dao.PersonDao;

public class PersonDaoImplDemo {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonDao personDao = (PersonDao) app.getBean("personDao");

        personDao.save();
    }
}
