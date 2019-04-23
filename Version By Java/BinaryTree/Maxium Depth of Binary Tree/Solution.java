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
    int maxDep = 0;
    public int maxDepth(TreeNode root) {
        depthHepler(root,1);
        return maxDep;
    }

    public void depthHepler(TreeNode root,int height){
        if(root == null) return;
        if(height > maxDep)
            maxDep = height;
        if(root.left != null)
            depthHepler(root.left,height+1);
        if(root.right != null)
            depthHepler(root.right,height+1);
        
    }
}