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
//方法一：采用BFS——在二叉树中又被叫做BFS
//方法一：采用BFS——在二叉树中又被叫做BFS
class Solution {
    public Node connect(Node root) {
        if(root == null)
            return null;
        Queue<Node> que = new LinkedList<Node>();
        //临时变量用来存储相邻的两个结点
        Node pre;
        Node now;
        que.offer(root);
        while(!que.isEmpty()){
            int levelNum = que.size();
            //用于保证第一趟遍历pre不会用于赋值，常第二趟开始才算
            pre = null;
            //一层间的遍历操作
            for(int i=0; i < levelNum;++i){
                now = que.poll();
                if(pre != null)
                    pre.next = now;
                if(now.left != null)    que.offer(now.left);
                if(now.right != null)   que.offer(now.right);
                pre = now;
            }
        }   
        return root;
    }
}