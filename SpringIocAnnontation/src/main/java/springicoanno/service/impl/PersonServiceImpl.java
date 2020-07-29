package springicoanno.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import springicoanno.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import springicoanno.service.PersonService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

// 代替<bean>配置
@Scope("singleton")
@Service("personService")
public class PersonServiceImpl implements PersonService {
    // 通过value获取容器中配置文件的数值
    @Value("${jdbc.url}")
    private String url;

    // 代替<properties>配置注入
    // @Autowired //可以注释掉Qualifier autowired会从spring容器中按照类型进行匹配，相当于按照类型匹配
    // @Qualifier("personDao") // 是按照 id值从容器中进行匹配，但是这个必须要结合autowired进行使用

    @Resource(name = "personDao") // resource相当于 autowire和qualifier的结合
    private PersonDao personDao;

    public PersonServiceImpl(){
        System.out.println("无参构造");
    }

    public PersonServiceImpl(PersonDao personDao){
        System.out.println("有参构造");
        this.personDao = personDao;
    }

    public PersonDao getPersonDao() {
        return personDao;
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    public void save() {
        System.out.println(this.url);
        this.personDao.save();
    }

    @PostConstruct
    public void init(){
        System.out.println("初始化方法");
    }

    @PreDestroy
    public void destory(){
        System.out.println("销毁方法");
    }
}
