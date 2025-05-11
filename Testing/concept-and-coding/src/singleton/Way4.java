package singleton;

/**
 * Creating through lazy loading with double-checked locking
 * This thread safe as it is using volatile and it will update the main memory
 */
public class Way4 {
    private static volatile Way4 instance = null;

    private Way4() {
    }

    public static Way4 getInstance() {
        if(instance == null) {
            synchronized(Way4.class) {
                if(instance == null) {
                    instance = new Way4();
                }
            }
        }
        return instance;
    }
}
