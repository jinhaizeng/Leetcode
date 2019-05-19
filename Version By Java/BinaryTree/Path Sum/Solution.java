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
            
        }
        
        if(root.left != null) hasPathSumHelper(root.left,sum,presentSum);
        if(root.right != null) hasPathSumHelper(root.right,sum,presentSum);
        return false;
        
    }
}

//以上的方法实现失败，必须采用如下的方法进行改进：
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return root!=null && hasPathSumHelper(root,sum,0);
    }
    public boolean hasPathSumHelper(TreeNode root , int sum, int presentSum){
        if(root == null) return false;
        presentSum += root.val;
        if(root.left == null && root.right == null){
            if(presentSum == sum)
                return true;
            
        }
        
        return hasPathSumHelper(root.left,sum,presentSum) || hasPathSumHelper(root.right,sum,presentSum);
    }
}



//方法二，网上大神给的思路
class Solution{
    public boolean hasPathSum(TreeNode root, int sum){
        if(root == null)    return false;
        if(root.left == null && root.right == null && sum - root.val == 0) return true;

        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }
}