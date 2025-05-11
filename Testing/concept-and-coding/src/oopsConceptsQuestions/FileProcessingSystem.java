package oopsConceptsQuestions;

public class FileProcessingSystem {
    public static void main(String[] args) {
        FileProcessor textFileProcessor = FileProcessorFactory.getFileProcessor(FileType.TEXT);
        textFileProcessor.processFile("sample.txt");

        FileProcessor pdfFileProcessor = FileProcessorFactory.getFileProcessor(FileType.PDF);
        pdfFileProcessor.processFile("sample.pdf");
    }
}

enum FileType{
    TEXT, PDF
}

interface FileProcessor{

    FileType getType();
    void processFile(String fileName);
}

class TextFileProcessor implements FileProcessor{

    public FileType getType(){
        return FileType.TEXT;
    }
    @Override
    public void processFile(String fileName) throws TextFileException{
        try{
            System.out.println("Processing text file: " + fileName);
            throw new Exception("File processing failed");
        }catch (Exception e){
            throw new TextFileException("File processing failed", e);
        }
    }
}

class PdfFileProcessor implements FileProcessor{
    @Override
    public FileType getType() {
        return FileType.PDF;
    }

    @Override
    public void processFile(String fileName) {
        System.out.println("Processing PDF file: " + fileName);
    }
}

class FileProcessorFactory{
    public static FileProcessor getFileProcessor(FileType fileType){
        return switch (fileType) {
            case TEXT -> new TextFileProcessor();
            case PDF -> new PdfFileProcessor();
            default -> throw new IllegalArgumentException("Invalid file type: " + fileType);
        };
    }
}

class TextFileException extends RuntimeException{

    public TextFileException(String message, Throwable cause) {
        super(message, cause);
    }
}

class PdfFileException extends RuntimeException{

    public PdfFileException(String message, Throwable cause) {
        super(message, cause);
    }
}




