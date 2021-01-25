class MinStack {
    class Node {
        int val;
        int minVal;
        public Node(int val, int minVal) {
            this.val = val;
            this.minVal = minVal;
        }
    }

    Stack<Node> mStack;
    /** initialize your data structure here. */
    public MinStack() {
        mStack = new Stack<Node>();
    }
    
    public void push(int x) {
        if (mStack.isEmpty()) {
            int minVal = x;
        } else {
            int minVal = (mStack.peek().minVal > x) ? x : mStack.peek().minVal;
        }
        Node node = new Node(x, minVal);
        mStack.push(node);
    }
    
    public void pop() {
        mStack.pop();
    }
    
    public int top() {
        return mStack.peek().val;
    }
    
    public int getMin() {
        return mStack.peek().minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */