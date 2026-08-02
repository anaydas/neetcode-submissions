public class DoubleNode{
    int key;
    int val;
    DoubleNode prev;
    DoubleNode next;

    public DoubleNode(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {

    private int capacity;
    Map<Integer,DoubleNode> cache;
    DoubleNode left;
    DoubleNode right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = new DoubleNode(0,0);
        this.right = new DoubleNode(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    private void remove(DoubleNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(DoubleNode node){
        DoubleNode prev = this.right.prev;
        prev.next = node;
        node.next = this.right;
        this.right.prev = node;
        node.prev = prev;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            DoubleNode node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        DoubleNode node = new DoubleNode(key,value);
        cache.put(key,node);
        insert(node); 
        if(cache.size() > capacity){
            DoubleNode lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }

    }
}
