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
    public boolean isValidBST(TreeNode root) {
        return preOrder(root);
    }
    public boolean preOrder(TreeNode root, TreeNode pre) {
        if (root == null) return true;
        boolean leftPass = false;
        boolean rightPass =false;
        if (root.left == null) {
            leftPass = true;
        } else {
            leftPass = root.left.val < root.val;
        }

        if (root.right == null) {
            left = true;
        } else {
            rightPass = root.right.val > root.val;
        }
        if (leftPass
                || rightPass
                || ((root == pre.left) && (root.right.val >= pre.val))
                || ((root == pre.right) && (root.left.val <= pre.val))) {
            return false;
        }

        boolean result = false;
        result = preOrder(root.left, root);
        if (!result) return false;
        result = preOrder(root.right, root);
        if (!result) return false;
        return true;
    }
}