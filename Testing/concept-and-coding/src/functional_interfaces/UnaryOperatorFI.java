package functional_interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class UnaryOperatorFI {
    public static void main(String[] args) {
        UnaryOperator<String> unaryOperator = String :: toUpperCase;
        List<String> list = Arrays.asList("one", "two", "three");
        list.stream().forEach(s -> System.out.println(unaryOperator.apply(s)));

    }
}
