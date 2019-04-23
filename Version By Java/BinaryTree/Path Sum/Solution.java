/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 方法一：用DFS的思路找路径（自己想的思路）。有个弯没有转过来：函数终止条件的判断怎么来的？？？？
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return root!=null && hasPathSumHelper(root,sum,0);
    }
    public boolean hasPathSumHelper(TreeNode root , int sum, int presentSum){
        
        presentSum += root.val;
        if(root.left == null && root.right == null){
            if(presentSum == sum)
                return true;
            else
                return false;
        }
        
        if(root.left != null) hasPathSumHelper(root.left,sum,presentSum);
        if(root.right != null) hasPathSumHelper(root.right,sum,presentSum);
        
    }
}
