package design_patterns.decorator_pattern.practiceQuestion.inputstream;

import java.io.FileNotFoundException;

public class DriverClass {

    public static void main(String[] args) throws FileNotFoundException {

        MyInputStream myInputStream = new FileInputStream("test.txt");
        myInputStream = new BufferInputStreamDecorator(myInputStream);
        myInputStream = new LoggingStreamDecorator(myInputStream);
        myInputStream.read();
    }
}
