package com.dongbawen.thrift.test.thrift;

import com.dongbawen.thrift.Person;
import com.dongbawen.thrift.PersonService;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * Created by blank on 2017/6/25.
 */
public class ThriftClient {
    public static void main(String[] args) {
        TTransport transport = new TFramedTransport(new TSocket("localhost", 8899), 600);
        TProtocol protocol = new TCompactProtocol(transport);
        PersonService.Client client = new PersonService.Client(protocol);

        try {
            transport.open();
            Person person = client.getPersonByUsername("张三");

            System.out.println(person.getAge());
            System.out.println(person.getUsername());
            System.out.println(person.isMarried());

            client.savePerson(person);
        } catch (Exception e) {
            throw  new RuntimeException(e.getMessage(), e);
        } finally {
            transport.close();
        }
    }
}
