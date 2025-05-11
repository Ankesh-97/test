package oopsConceptsQuestions;

import java.util.Date;

/*
Why we need immutable classes?
1. Immutable objects are thread-safe.
2. Immutable objects are good Map keys and Set elements, since these typically do not change once created.
Cacheable and Reusable: Immutable objects can be cached and reused multiple times.
Better Memory Management: Immutable objects are cached and reused multiple times.
 */

public class ImmutableClassDesign {
    public static void main(String[] args) {
        Date dob = new Date();
        dob.setTime(0);
        Person1 person = new Person1("John", dob);
        dob.setTime(5);
    }
}

final class Person1{
    private final String name;
    private final Date dob;

    public Person1(String name, Date dob){
        this.name = name;
        this.dob = (Date)dob.clone();
    }

    public String getName(){
        return name;
    }

    public Date getDob(){
        return  (Date)dob.clone();
    }

}
