package quickStart.dao.impl;

import quickStart.dao.PersonDao;
import quickStart.domin.Person;

import java.util.Map;
import java.util.Properties;

public class PersonDaoImpl implements PersonDao {
    private String username;
    private int age;

    private Map<String, Person> personMap;

    private Properties properties;

    public Map<String, Person> getPersonMap() {
        return personMap;
    }

    public void setPersonMap(Map<String, Person> personMap) {
        this.personMap = personMap;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PersonDaoImpl() {
        System.out.println("无参构造.....");
        System.out.println("Username is " + this.username);
        System.out.println("Age is " + this.age);

    }

    public void save() {
        System.out.println("Saving......");
        System.out.println("Username is " + this.username);
        System.out.println("Age is " + this.age);
        System.out.println(this.personMap);
        System.out.println(this.properties);
    }

    public void init() {
        System.out.println("init....");
    }

    public void destroy() {

        System.out.println("destroy....");
    }
}
