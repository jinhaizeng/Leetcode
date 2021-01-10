/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {t val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<LinkedList<Integer>> result = new LinkedList<LinkedList<Integer>>();
        queue.offer(root);
        int levelnum = 1;
        LinkedList
        while (!queue.isEmpty()) {
            root = queue.poll();
            
        }
    }
}