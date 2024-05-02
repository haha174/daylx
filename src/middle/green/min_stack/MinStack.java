package middle.green.min_stack;

class NodeList{
    int data,min;
    NodeList next;

    public NodeList(int num){
        this.data=num;
        this.min=num;
    }
}
class MinStack {
    private NodeList head;
    public MinStack() {
    }
    
    public void push(int val) {
        NodeList tmp=new NodeList(val);
        if (head==null){
            head=tmp;
        }else {
            tmp.min=Math.min(head.min,val);
            tmp.next=head;
            head=tmp;
        }
    }
    
    public void pop() {
        if (head!=null){
            head=head.next;
        }
    }
    
    public int top() {
        return head.data;
    }
    
    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */