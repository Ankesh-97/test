package design_patterns.decorator_pattern.practiceQuestion.TextEditor;

public class PlainText implements Text {

    private final String content;

    public PlainText(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return this.content;
    }


}
