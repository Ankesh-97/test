import org.example.Address;
import org.example.Person;
//import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Field;


public class TestPerson {

    //@Test
//    public void testPerson() throws IOException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
//        Person person = new Person();
//        person.setName("John");
//        person.setAge(30);
//        person.setHeight(180);
//        Address address = new Address();
//        address.setNumber(123);
//        person.setAddress(address);
//
//        FileOutputStream fos = new FileOutputStream("File.txt");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(person);
//        oos.flush();
//        oos.close();
//
//        FileInputStream fis = new FileInputStream("File.txt");
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        Person p2 = (Person) ois.readObject();
//        ois.close();
//
//        Field privateField
//                = Person.class.getDeclaredField("serialVersionUID");
//        privateField.setAccessible(true);
//        long serialVersionUID = (long) privateField.get(person);
//        long serialVersionUID2 = (long) privateField.get(p2);
//        System.out.println(serialVersionUID);
//        System.out.println(serialVersionUID2);
//        assertEquals(serialVersionUID, serialVersionUID2);
//
//
//        //assertEquals(person.getName(), p2.getName());
//    }

}
