import java.util.HashMap;



import java.util.LinkedHashMap;
import java.util.Map;

class LRUUsingLHM {
    LinkedHashMap<Integer,Integer> cache;

    LRUUsingLHM(int capacity){
        this.cache = new LinkedHashMap<>(capacity,0.75f,true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }
    void put(int x,int y){
        cache.put(x,y);
    }
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }
}
class CNode {
    int key,value;
    CNode next,prev;
    CNode(int key, int value){
        this.key = key;
        this.value = value;
    }
}
class LRUCache
{
    //Constructor for initializing the cache capacity with the given value.

    private final CNode head = new CNode(0,0);
    private final CNode tail = new CNode(0,0);

    private final HashMap<Integer,CNode> map = new HashMap<>();
    private final int capacity;

    LRUCache(int cap)
    {
        //code here
        capacity = cap;
        head.next = tail;
        tail.prev = head;

    }

    //Function to return value corresponding to the key.
    public int get(int key)
    {
        // your code here
        if(map.containsKey(key)){

            CNode temp = map.get(key);
            remove(temp);
            insert(temp);

            return temp.value;
        }

        return -1;
    }

    //Function for storing key-value pair.
    public void set(int key, int value)
    {
        // your code here

        //check map contains already or not
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        else if(capacity == map.size()){ // if map is full then remove tail CNode
            remove(tail.prev);
        }
        insert(new CNode(key,value)); // insert the data
    }

    private void insert(CNode data){

        map.put(data.key,data);
        CNode temp = head.next;
        head.next = data;
        data.prev = head;
        data.next = temp;
        temp.prev = data;

    }

    private void remove(CNode data){

        map.remove(data.key);
        data.prev.next = data.next;
        data.next.prev = data.prev;

    }

}

public class LRU_Cache {
    public static void main(String[] args) {

//        LRUCache cache = new LRUCache(2);
//        cache.set(1, 10);
//        cache.set(2, 20);
//
//        System.out.println(cache.get(1)); // Output: 10
//        cache.set(3, 30);
//        System.out.println(cache.get(2)); // Output: -1 (key 2 is no longer in the cache)
//        cache.set(4, 40);
//        System.out.println(cache.get(1)); // Output: -1 (key 1 is no longer in the cache)
//        System.out.println(cache.get(3)); // Output: 30
//        System.out.println(cache.get(4)); // Output: 40

        LRUUsingLHM cache = new LRUUsingLHM(2);

        cache.put(1, 10);
        cache.put(2, 20);

        System.out.println(cache.get(1)); // Output: 10
        cache.put(3, 30);
//        System.out.println(cache.get(2)); // Output: -1 (key 2 is no longer in the cache)
//        cache.put(4, 40);
//        System.out.println(cache.get(1)); // Output: -1 (key 1 is no longer in the cache)
//        System.out.println(cache.get(3)); // Output: 30
//        System.out.println(cache.get(4)); // Output: 40
    }
}
