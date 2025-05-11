package functional_interfaces;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/*
Method references in Java are a shorthand notation of a lambda expression to call a method.
They provide a way to refer to methods without invoking them. Method references can be used to refer to static methods,
instance methods, and constructors. They make the code more readable and concise.

Types of Method References
Reference to a Static Method
Reference to an Instance Method of a Particular Object
Reference to an Instance Method of an Arbitrary Object of a Particular Type
Reference to a Constructor
 */
public class MethodReference {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Using a static method reference
        numbers.forEach(MethodReference::printNumber);


        // Using an instance method reference of a particular object
        List<String> messages = Arrays.asList("Hello", "World", "Java");
        MethodReference instance = new MethodReference();
        messages.forEach(instance::printMessage);


        List<String> words = Arrays.asList("apple", "banana", "cherry");

        // Using a method reference to an instance method of an arbitrary object
        words.sort(String::compareToIgnoreCase);

        words.forEach(System.out::println);



        List<String> names = Arrays.asList("John", "Jane", "Jack");

        // Using a constructor reference
        Function<String, Person> personCreator = Person::new;

        names.stream()
                .map(personCreator)
                .forEach(System.out::println);
    }

    public static void printNumber(int number) {
        System.out.println(number);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "'}";
        }
    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "'}";
    }
}
