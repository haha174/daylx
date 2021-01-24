package easy.yellow.kth_largest_element_in_a_stream;

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

class KthLargest {

    Node root = new Node(Integer.MAX_VALUE);
    int k;
    int size = 0;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        Node node = root;
        int tempCount = k;
        int result = 0;
        while (true) {
            if (node.next == null || node.next.val < val) {
                break;
            }
            node = node.next;
            tempCount--;
            if (tempCount == 0) {
                result = node.val;
            }
        }
        Node temp = new Node(val);
        temp.next = node.next;
        node.next = temp;
        size++;
        if (tempCount > 0) {
            while (tempCount > 0 && node != null) {
                node = node.next;
                tempCount--;
            }
            if (node!=null){
                result = node.val;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, data);
        System.out.println(kthLargest.add(3)); // return 4
        System.out.println(kthLargest.add(5)); // return 5
        System.out.println(kthLargest.add(10)); // return 5
        System.out.println(kthLargest.add(9));// return 8
        System.out.println(kthLargest.add(4)); // return 8
    }
}