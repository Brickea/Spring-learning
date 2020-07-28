package quickStart.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import quickStart.dao.PersonDao;
import quickStart.service.PersonService;

public class PersonServiceImpl implements PersonService {
    private PersonDao personDao;

    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    public PersonServiceImpl() {
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    public void save() {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        PersonDao p = (PersonDao) app.getBean("personDao");
//        p.save();
        this.personDao.save();
    }
}
