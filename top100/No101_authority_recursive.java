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
    public boolean isSymmetric(TreeNode root) {
        return isMirrorTree(root, root);
    }
    public boolean isMirrorTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        boolean empty = (node1 == null && node2 != null)
                || (node1 !=null && node2 == null);
        if (empty) {
            return false;
        }
        return node1.val == node2.val && isMirrorTree(node1.left, node2.right) && isMirrorTree(node1.right, node2.left);
    }
}