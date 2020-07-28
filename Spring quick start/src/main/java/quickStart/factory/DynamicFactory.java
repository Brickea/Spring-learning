package quickStart.factory;

import quickStart.dao.PersonDao;
import quickStart.dao.impl.PersonDaoImpl;

public class DynamicFactory {
    public PersonDao getPersonDao(){
        return new PersonDaoImpl();
    }
}
