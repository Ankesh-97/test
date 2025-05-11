package singleton;

/**
 * Creating through eager loading
 */
public class Way2 {

        private static Way2 instance = new Way2();

        private Way2() {
        }

        public static Way2 getInstance() {
            return instance;
        }
}
