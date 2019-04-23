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

    // 第一种方法，自己写的先序遍历的解决方法，但是代码还是偏复杂
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


    // 第二种方法，leetcode上面极简的解决方法，更相当于从地向上的思路，如果实际应用想到的话，那就傻一点，遍历吧
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}

