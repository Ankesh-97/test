package singleton;

/**
 * Creating through lazy loading with double-checked locking
 * But this is thread safe but some times due memory sync issue can lead to multiple instance creation
 */
public class Way3 {

    private static Way3 instance = null;

    private Way3() {
    }

    public static Way3 getInstance() {
        if(instance == null) {
            synchronized(Way3.class) {
                if(instance == null) {
                    instance = new Way3();
                }
            }
        }
        return instance;
    }
}
