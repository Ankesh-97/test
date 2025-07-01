package design_patterns.decorator_pattern.practiceQuestion.inputstream;

public abstract class MyInputStreamDecorator implements MyInputStream {

    private MyInputStream myInputStream;

    protected MyInputStreamDecorator(MyInputStream myInputStream) {
        this.myInputStream = myInputStream;
    }

    protected final MyInputStream getMyInputStream() {
        return this.myInputStream;
    }

}
