package org.example.practiceQuestion.inputstream;

public class LoggingStreamDecorator extends MyInputStreamDecorator {
    protected LoggingStreamDecorator(MyInputStream myInputStream) {
        super(myInputStream);
    }

    @Override
    public int read() {
        int data = super.getMyInputStream().read();
        System.out.println("Read byte: " + data);
        return data;
    }

}
