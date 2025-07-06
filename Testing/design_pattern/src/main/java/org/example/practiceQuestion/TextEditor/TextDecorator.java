package org.example.practiceQuestion.TextEditor;

public abstract class TextDecorator implements Text {

    private Text text;

    protected TextDecorator(Text text) {
        this.text = text;
    }

    protected final Text getText() {
        return this.text;
    }
}
