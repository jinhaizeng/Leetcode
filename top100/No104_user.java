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
    public int maxDepth;
    public int maxDepth(TreeNode root) {
        findDepth(root, 1);
        return maxDepth;
    }
    public void findDepth (TreeNode root, int currDepth) {
        if(root == null) {
            return;
        }

        if (currDepth > maxDepth) {
            maxDepth = currDepth;
        }
        findDepth(root.left, currDepth + 1);
        findDepth(root.right, currDepth + 1);
    }
}