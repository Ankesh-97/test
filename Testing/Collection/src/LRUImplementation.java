import java.util.LinkedHashMap;
import java.util.Map;

public class LRUImplementation<String, Integer> extends LinkedHashMap<String, Integer> {

    private final int maxEntries;

    public LRUImplementation(int maxEntries) {
        super(5, 0.75f, true);
        this.maxEntries = maxEntries;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
        return size() > maxEntries;
    }
}
