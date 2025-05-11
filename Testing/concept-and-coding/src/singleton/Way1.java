package singleton;


/**
 * Creating through lazy loading
 */
public class Way1 {

    private static Way1 instance = null;

    private Way1() {
    }

    public static Way1 getInstance() {
        if (instance == null) {
            instance = new Way1();
        }
        return instance;
    }
}
