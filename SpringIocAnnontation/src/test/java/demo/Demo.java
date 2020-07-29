package demo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springicoanno.service.PersonService;

public class Demo {

    @Test
    public void WebSimulation(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonService pS = app.getBean(PersonService.class);
        PersonService pS1 = app.getBean(PersonService.class);
        pS.save();
        System.out.println(pS==pS1);

        ((ClassPathXmlApplicationContext) app).close();
    }
}
