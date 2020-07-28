package quickStart.factory;

import quickStart.dao.PersonDao;
import quickStart.dao.impl.PersonDaoImpl;

public class StaticFactory {
    // 获取bean实例的工厂静态方法构造
    public static PersonDao getPersonDao(){
        return new PersonDaoImpl();
    }
}
