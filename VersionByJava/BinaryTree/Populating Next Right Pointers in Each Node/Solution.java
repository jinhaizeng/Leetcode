/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if(root == null)
            return null;
        connectHelper(root.left,root.right);
        return root;
        
    }
    public boolean connectHelper(Node left,Node right){
        //首先写出终止条件
        if(left == null && right == null)
            return false;
        if(right != null)
            left.next = right;
        connectHelper(left.left,left.right);
        connectHelper(left.right,right.left);
        connectHelper(right.left,right.right);
        return true;
    }
}