package solid_design_principle;

public class InterfaceSegmentedPrinciple {

    public static void main(String[] args) {

    }
}

// Interface Segregation or segmented Principle violation
// below is a interface which has contract for all the employee of restaurant
// but dumping all the methods in one interface is not a good idea, as not all the employee can do all the tasks
// like waiter can't clean table or handle payment but still they have to implement those methods

//so to avoid such scenarios we should have separate interfaces for each type of employee.

interface RestaurantEmployee{
    void takeOrder();
    void serveOrder();
    void cleanTable();
    void handlePayment();
}

class Waiter implements RestaurantEmployee{

    @Override
    public void takeOrder() {
        System.out.println("Waiter takes order");
    }

    @Override
    public void serveOrder() {
        System.out.println("Waiter serves order");
    }

    @Override
    public void cleanTable() {
       throw new UnsupportedOperationException("Waiter can't clean table");
    }

    @Override
    public void handlePayment() {
       throw new UnsupportedOperationException("Waiter can't handle payment");
    }
}
