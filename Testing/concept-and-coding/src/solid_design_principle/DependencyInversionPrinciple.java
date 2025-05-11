package solid_design_principle;

public class DependencyInversionPrinciple {

    public static void main(String[] args) {

    }
}

// Dependency Inversion Principle says that high level modules should not depend on low level modules,
// both should depend on abstractions.

// Interface or abstract classes should be used instead of concrete classes,which makes the system more flexible and maintainable.


interface Keyboard{
    void type();
}

interface Monitor{
    void display();
}

class Macbook{
    Keyboard keyboard;
    Monitor monitor;

    public Macbook(Keyboard keyboard, Monitor monitor) {
        this.keyboard = keyboard;
        this.monitor = monitor;
    }

    public void type(){
        keyboard.type();
    }

    public void display(){
        monitor.display();
    }
}
