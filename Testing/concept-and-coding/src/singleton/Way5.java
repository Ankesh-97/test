package singleton;

/**
 * Creating through lazy loading with bill paugh way which using inner static class
    * This is lazy loading loading inner static class load when it is called
 */
public class Way5 {

    private Way5() {
    }

    private static class SingletonHelper {
        private static final Way5 INSTANCE = new Way5();
    }

    public static Way5 getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
