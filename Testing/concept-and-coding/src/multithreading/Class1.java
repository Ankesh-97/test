package multithreading;

public class Class1 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
    }
}

class Class2 implements Runnable {
    public static void main(String[] args) {
        Thread t = new Thread(new Class2());
        t.start();
        System.out.println(Thread.currentThread().getName());
    }

    @Override
    public void run() {

    }
}
