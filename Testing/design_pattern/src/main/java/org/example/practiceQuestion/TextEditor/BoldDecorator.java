package org.example.practiceQuestion.TextEditor;

public class BoldDecorator extends TextDecorator {

    protected BoldDecorator(Text text) {
        super(text);
    }

    @Override
    public String getContent() {
        return "Bold " + super.getText().getContent() + " Bold";
    }
}
