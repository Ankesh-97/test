package design_patterns.decorator_pattern.practiceQuestion.TextEditor;

public class Underlined extends TextDecorator {
    protected Underlined(Text text) {
        super(text);
    }

    @Override
    public String getContent() {
        return "Underlined " + super.getText().getContent() + " Underlined";
    }
}
