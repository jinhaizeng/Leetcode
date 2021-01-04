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
        return helper (root, null, null);
    }
    public boolean helper (TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }

        if (lower != null && lower >= root.val) {
            return false;
        }
        if (upper != null && upper <= root.val) {
            return false;
        }
        if (!helper(root.left, lower, root.val)) {
            return false;
        }
        if (!helper(root.right, root.val, upper)) {
            return false;
        }
        return true;
    }
}