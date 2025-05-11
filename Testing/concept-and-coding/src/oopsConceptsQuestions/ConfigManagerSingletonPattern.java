package oopsConceptsQuestions;

/*
Issues with the Singleton Pattern:

Common issues with the Singleton pattern include testability, tight coupling, and serialization problems,
which can be mitigated using dependency injection, proper serialization handling, and careful
design of the Singleton class.
 */

public class ConfigManagerSingletonPattern {
    public static void main(String[] args) {
//        ConfigManager configManager1 = ConfigManager.getInstance();
//        ConfigManager configManager2 = ConfigManager.getInstance();

        for(int i=0;i<5;i++){
            Thread thread = new Thread(ConfigManager::getInstance);
            thread.start();
        }

    }
}

class ConfigurationManager {
    // Step 1: Create a private static variable for the single instance.
    private static ConfigurationManager instance;

    // Step 2: Make the constructor private to prevent instantiation.
    private ConfigurationManager() {
        // Load configurations here (e.g., from a file or environment variables)
    }

    // Step 3: Provide a public method to return the instance of the class.
    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    // Configuration methods...
    public String getConfig(String key) {
        // Return the configuration for the given key
        return "value";
    }
}


/*
Pros: Simple and easy to implement.
Cons: Synchronizing the entire method can cause performance bottlenecks, especially if getInstance() is called frequently.
 */
class ConfigManager1 {

    private static ConfigManager1 configManager1;

    private ConfigManager1() {
        // private constructor
    }

    public static synchronized ConfigManager1 getInstance() {
        if (configManager1 == null) {
            System.out.println("Creating new instance with thread  " + Thread.currentThread().getName());
            configManager1 = new ConfigManager1();
        } else {
            System.out.println("Instance already exists with thread  " + Thread.currentThread().getName());
        }
        return configManager1;
    }

    @Override
    public ConfigManager clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}

/*
Pros: More efficient than synchronizing the entire method.
Cons: More complex, but it addresses multithreading concerns efficiently.
 */
class ConfigManager {
        private static volatile ConfigManager configManager;

        private ConfigManager() {
            // private constructor
        }

        public static ConfigManager getInstance() {

            if (configManager == null) {
                synchronized (ConfigManager.class) {
                    if (configManager == null) {
                        System.out.println("Creating new instance with thread  " + Thread.currentThread().getName());
                        configManager = new ConfigManager();
                    } else {
                        System.out.println("Got the lock but Instance already exists with thread  " + Thread.currentThread().getName());
                    }
                }
            } else {
                System.out.println("Instance already exists with thread  " + Thread.currentThread().getName());
            }
            return configManager;
        }

        @Override
        public ConfigManager clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
}


/*
Bill Pugh Singleton Design (Initialization-on-demand holder idiom):

Pros: It leverages Java's class-loading mechanism to ensure thread safety and lazy initialization.
Cons: None significant; this is generally considered a best practice for implementing Singleton in Java.

 */
class ConfigurationManager1 {

    private ConfigurationManager1() {
        // Load configurations
    }

    private static class SingletonHelper {
        private static final ConfigurationManager1 INSTANCE = new ConfigurationManager1();
    }

    public static ConfigurationManager1 getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
