package solid_design_principle;

public class SingleResponsibilityPrinciple {
    public static void main(String[] args) {

    }
}

/*
 In the below example, we have a Book class that represents a book. We have an Invoice class that represents an invoice for a book. We have a BookStore class that sells a book.
 The Book class has a single responsibility to represent a book.
 But The Invoice class has a multiple responsibility -> to calculate the total price of the book and to print the invoice and also to save invoice.

 So we can split the Invoice class into multiple classes,and each class will have a single responsibility.
 So SRP says that a class should have only one reason to change.
  */

class Book {

    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

class Invoice {

    private Book book;
    private int quantity;

    public Invoice(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public double calculateTotalPrice() {
        return book.getPrice() * quantity;
    }

    public void printInvoice(){
        System.out.println("Price : "+ calculateTotalPrice());
    }

    public void saveInvoice(){
        // Save invoice to database
    }
}

class BookStore {

    public void sellBook(Book book, int quantity) {
        Invoice invoice = new Invoice(book, quantity);
        invoice.printInvoice();
        invoice.saveInvoice();
    }
}

