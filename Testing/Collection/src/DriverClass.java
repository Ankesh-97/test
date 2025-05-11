public class DriverClass {

    public static void main(String[] args) {
        LRUImplementation<String, Integer> lruCache = new LRUImplementation<>(10);
        for(int i = 0; i < 15; i++) {
            lruCache.put("key" + i, i);
            lruCache.get("key0");
        }
       // lruCache.get("key0");
        System.out.println("Cache contents after adding 15 items: " + lruCache);
    }
}
