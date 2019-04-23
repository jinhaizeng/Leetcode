/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 方法一：采用BFS，遍历一层以后，判断这一层是不是对称的，如果是对称的，就往下一层走
// 思考边界条件：左右子树有一个为空即是不对称
// 还有一个要点，有功不计，有过必罚
// 这种最蠢的方法也AC出来了，那么第一遍刷leetcode就从自己的思路开始刷吧
class Solution {
    
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        return Hepler(root,queue);
    }
    public boolean  Hepler(TreeNode root, Queue<TreeNode> queue){
        if(root == null) return true;
        TreeNode temp;
        queue.offer(root);
        temp = queue.poll();
        if((temp.left == null && temp.right != null)||(temp.left != null && temp.right == null))
            return false;
        else{
            if(temp.left != null && temp.right != null){
                if(temp.left.val != temp.right.val)
                    return false;
                queue.offer(temp.left);
                queue.offer(temp.right);
            }
            
        }
        while(!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            //从第三层遍历的角度写的代码
           
            if((left.left != null && right.right == null)||(left.left == null && right.right != null))
                return false;
            else{
                if(left.left != null && right.right != null){
                    if(left.left.val != right.right.val)
                        return false;
                    queue.offer(left.left);
                    queue.offer(right.right);
                }
                
            }

            
            if((left.right != null && right.left == null)||(left.right == null && right.left != null))
                return false;
            else{
                if(left.right != null && right.left != null){
                    if(left.right.val != right.left.val)
                        return false;
                    queue.offer(left.right);
                    queue.offer(right.left);
                }
                
            }
            
        }
        return true;
    }
}