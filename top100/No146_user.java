class LRUCache {
    class DLinkedNode {
        int key;        //这个key是用来清除map中队尾node对应key的，否则还要遍历
        int val;
        DLinkedNode pre;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
            pre = null;
            next = null;
        }
    }

    private DLinkedNode head;
    private DLinkedNode tail;
    private HashMap<Integer, DLinkedNode> map = new HashMap<Integer, DLinkedNode>();
    private int capacity = 0;

    public LRUCache(int capacity) {
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            moveToHead(map.get(key));
            return map.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            moveToHead(map.get(key));
            map.get(key).val = value;
        } else {
            DLinkedNode node = new DLinkedNode(key, value);
            if (map.size() == this.capacity) {
                map.remove(tail.pre.key);
                removeNode(tail.pre);
            } 
            addToHead(node);
            map.put(key, node);
        }
    }

    private void addToHead(DLinkedNode node) {
        head.next.pre = node;
        node.next = head.next;
        node.pre = head;
        head.next = node;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void removeTail() {
        map.remove(tail.pre.key);
        if (tail.pre == head) {
            return;
        }
        tail.pre.pre.next = tail;
        tail.pre = tail.pre.pre;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */