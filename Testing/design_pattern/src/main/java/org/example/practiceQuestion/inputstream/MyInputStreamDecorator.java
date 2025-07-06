package org.example.practiceQuestion.inputstream;

public abstract class MyInputStreamDecorator implements MyInputStream {

    private MyInputStream myInputStream;

    protected MyInputStreamDecorator(MyInputStream myInputStream) {
        this.myInputStream = myInputStream;
    }

    protected final MyInputStream getMyInputStream() {
        return this.myInputStream;
    }

}
