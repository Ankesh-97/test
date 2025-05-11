package singleton;

/**
 * Creating through Enum as it is thread safe, serialization safe and reflection safe
 * But it is not lazy loading
 */
public enum Way6 {
    INSTANCE;
}
