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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> pre = new LinkedList<Integer>();
        inorderHelper(root,pre);
        return pre;
    }
    public void inorderHelper(TreeNode root,List<Integer> pre){
        if(root == null) return;
        inorderHelper(root.left,pre);
        pre.add(root.val);
        inorderHelper(root.right,pre);
    }
}