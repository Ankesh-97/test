package oopsConceptsQuestions;

public class ObjectCloning {

    /*
    By default, clone() performs a shallow copy, meaning it copies the references of fields, not the actual objects.

    Why is Cloneable interface considered controversial in Java?

    >The Cloneable interface is considered controversial in Java because it does not contain any methods.
    Instead, it is a marker interface that allows the Object.clone() method to be called on an object.
    However, the Object.clone() method is protected, so it cannot be called directly from outside the class.
    This means that classes that implement the Cloneable interface must override the clone()
    method to make it public.

    >The clone() method is actually defined in the Object class, and calling it directly without overriding
    often leads to a CloneNotSupportedException.


    Solutions :

    In practice, alternatives like copy constructors or factory methods are often preferred as
    they provide more control and are easier to maintain.
     */

}

class Department{

    private Manager manager;

    public Department(Manager manager){
        this.manager = manager;
    }

    public Department clone(){
        Manager manager1 = this.manager.clone();
        return  new Department(manager1);
    }
}

class Manager{

    int id;
    String name;


    public Manager clone(){
        Manager manager = new Manager();
        manager.id = this.id;
        manager.name = new String(this.name);
        return manager;
    }

}
