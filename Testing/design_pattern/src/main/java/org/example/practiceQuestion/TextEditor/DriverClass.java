package org.example.practiceQuestion.TextEditor;

public class DriverClass {

    public static void main(String[] args) {
        Text text = new Underlined(new BoldDecorator(new PlainText("Hello World")));
        System.out.println(text.getContent());
    }
}
