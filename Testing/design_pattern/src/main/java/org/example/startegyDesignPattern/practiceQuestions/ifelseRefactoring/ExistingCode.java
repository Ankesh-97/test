package src.design_patterns.startegyDesignPattern.practiceQuestions.ifelseRefactoring;

public class ExistingCode {
    public static void main(String[] args) {
        String type = "A";
        int value = 10;
        int result = 0;

        if (type.equals("A")) {
            result = value * 2;
        } else if (type.equals("B")) {
            result = value + 5;
        } else if (type.equals("C")) {
            result = value - 3;
        } else {
            System.out.println("Invalid type");
        }

        System.out.println("Result: " + result);
    }
}
