package interview;

import java.io.File;

public class TestClass {

}

class FileProcessor{
    public void processFile(File file){
        // check if file is pdf then process
        // check if file is txt then process
    }
}

class PDFFileProcessor extends FileProcessor{

    public String getExtension(File file){
        return "pdf";
    }

    public void processFile(File file){
        // process pdf file
    }
}
