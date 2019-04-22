/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> pre = new LinkedList<Integer>();
        postorderHelper(root,pre);
        return pre;
    }
    public void postorderHelper(TreeNode root,List<Integer> pre){
        if(root == null)    return;
        postorderHelper(root.left,pre);
        postorderHelper(root.right,pre);
        pre.add(root.val);
    }
}