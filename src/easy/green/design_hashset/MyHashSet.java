package easy.green.design_hashset;

class Node {
    Node prev;
    Node next;
    int val;

    Node() {
        prev = this;
        next = this;
    }

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node prev, Node next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}


class MyHashSet {
    Node[] nodes;
    int n;
    /** Initialize your data structure here. */
    public MyHashSet() {
        n = 10000;
        nodes = new Node[n];
    }

    public void add(int key) {
        if (contains(key)) {
            return;
        }
        int i = key % n;
        if (nodes[i] == null) {
            nodes[i] = new Node();
        }
        Node node = new Node(key, nodes[i].prev, nodes[i]);
        nodes[i].prev.next = node;
        nodes[i].prev = node;
    }

    public void remove(int key) {
        int i = key % n;
        if (nodes[i] == null) {
            return;
        }
        Node cur = nodes[i].next;
        while (cur != nodes[i]) {
            if (cur.val == key) {
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                cur.next = null;
                cur.prev = null;
                return;
            }
            cur = cur.next;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int i = key % n;
        if (nodes[i] == null) {
            return false;
        }
        Node cur = nodes[i].next;
        while (cur != nodes[i]) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
}