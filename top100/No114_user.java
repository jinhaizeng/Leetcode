/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        transform(root);
    }
    public void transform(TreeNode root) {
        if (root == null) {
            return;
        }
        transform(root.left);
        transform(root.right);
        TreeNode temp = root;
        if (root.left != null) {
            root = root.left;
            while(root.right != null) {
                root = root.right;
            }
            root.right = temp.right;
            temp.right = temp.left;
            temp.left = null;
        }
    }
}