package oopsConceptsQuestions;

public class OverridingVsOverloading {
    public static void main(String[] args) {
       Calculator cal = new Calculator();
       System.out.println(cal.add(1, 2));
       System.out.println(cal.add(1.0, 2.0));
       Calculator sci = new ScientificCalculator();
       System.out.println(sci.add(1.0, 2.0));
    }
}

class Calculator {
    public int add(int a, int b) {
        System.out.println("Overloading the add method.");
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }
}

class ScientificCalculator extends Calculator {

    @Override
    public double add(double a, double b) {
        System.out.println("Overriding the add method in ScientificCalculator");
        return a + b;
    }
}
