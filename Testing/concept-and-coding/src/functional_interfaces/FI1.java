package functional_interfaces;

@FunctionalInterface
public interface FI1 {

    int calculate(int a, int b);
    static String method1() {
        return "input.toUpperCase()";
    }
}
