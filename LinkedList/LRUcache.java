// we'll use doubly linked list and a map
// then our complexicity will become O(1)
// otherwise it'll be O(N) as we have to traverse every node ourselves 
// TC -> O(1)
class Node{
    int key;
    int val;
    Node next;
    Node prev;

    Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    HashMap<Integer, Node> map = new HashMap<>();
    int capacity;
    Node head = new Node(0,0);
    Node tail = new Node(0,0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map.clear();
        head.next = tail;
        tail.prev = head;

    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);

        deleteNode(node);
        insertAfterHead(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){
            Node node = map.get(key);
            deleteNode(node);
            node.val = value;
            insertAfterHead(node);
            return;
        }

        if(map.size() == capacity){
            Node node = tail.prev;
            map.remove(node.key);
            deleteNode(node);
        } 

        Node node = new Node(key, value);
        insertAfterHead(node);
        map.put(key, node);
    }

    void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void insertAfterHead(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */