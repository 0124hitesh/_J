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

// class LRUCache {
//     Node head, tail;
//     int capacity;
//     Map<Integer, Node> m;

//     void addNode(Node n){
//         n.pre = head;
//         n.next = head.next;
//         head.next = n;
//         n.next.pre = n;
//     }

//     void removeNode(Node n){
//         n.pre.next = n.next;
//         n.next.pre = n.pre;
//     }

//     void moveToHead(Node n){
//         removeNode(n);
//         addNode(n);
//     }

//     public LRUCache(int capacity) {
//         this.capacity = capacity;
//         m = new HashMap<>(capacity + 1, 1);
//         head = new Node();
//         tail = new Node();
//         head.next = tail;
//         tail.pre = head;
//     }
    
//     public int get(int key) {
//         if(m.containsKey(key)){
//             Node n = m.get(key);
//             moveToHead(n);
//             return n.value;
//         }

//         return -1;
//     }
    
//     public void put(int key, int value) {
//         if(m.containsKey(key)){
//             Node n = m.get(key);
//             n.value = value;
//             moveToHead(n);
            
//         }
//         else{
//             if(m.size() == capacity){
//                 Node p = tail.pre;
//                 m.remove(p.key);
//                 removeNode(p);
//             }

//             Node n = new Node(key, value);
//             addNode(n);
//             m.put(key, n);
//         }
//     }
// }

// class Node{
//     int key, value;
//     Node pre, next;

//     Node(){}

//     Node(int k, int v){
//         key = k;
//         value = v; 
//     }
// }