package com.dongbawen.thrift.test.thrift;

import com.dongbawen.thrift.DataException;
import com.dongbawen.thrift.Person;
import com.dongbawen.thrift.PersonService;
import org.apache.thrift.TException;

/**
 * Created by blank on 2017/6/25.
 */
public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        System.out.println("got client param: " + username);
        Person person  = null;
        person = new Person();
        person.setAge(20);
        person.setMarried(false);
        person.setUsername("wangzhiyun");
        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("got client param: " + person);
    }
}
