package DaoDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import quickStart.service.PersonService;

public class PersonController {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonService pS = (PersonService)app.getBean("personService");
        pS.save();
    }
}
