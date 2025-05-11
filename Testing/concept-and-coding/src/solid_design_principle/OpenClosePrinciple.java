package solid_design_principle;

public class OpenClosePrinciple {
    public static void main(String[] args) {

    }
}

/*
Below is an example of violation of Open Close Principle.
In the below example, we have a ProcessFile class that processes a Pdf file, and if we want to process a Word file,
we need to modify the ProcessFile class.So the ProcessFile class is not closed for modification.

To correct this violation, we can create a new class for processing a Word file,
and the ProcessFile class will be closed for modification, or we can create a
interface which will have a method to process a file, and whichever type of file comes we can implement that interface.

 */

class ProcessFile{
    public void processPdfFile() {
        // Process Pdf file
    }
}
