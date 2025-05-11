package control_flow_statements;

public class Main {
    public static void main(String[] args) {
        final int x = 10;

        switch(1+2){
            case x:
                System.out.println("Case 1");
                return;
            default:
                System.out.println("Default case");
        }
    }
}
