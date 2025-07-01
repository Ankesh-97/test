package design_patterns.decorator_pattern.practiceQuestion.inputstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStream implements MyInputStream {

    private java.io.FileInputStream fis;

    public FileInputStream(String fileName) throws FileNotFoundException {
        this.fis = new java.io.FileInputStream(new File(fileName));
    }

    @Override
    public int read() {
        try {
            return fis.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
