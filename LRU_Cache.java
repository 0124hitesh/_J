import java.util.*;


class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;
    public LRUCache(int capacity) {
        super(capacity + 2, 1, true);
        this.capacity = capacity;
    }
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }
    public void put(int key, int value) {
        super.put(key, value);
    }

    // for every insertion, remove eldest entry if returns true
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> m){
        return size() > capacity;
    }
}