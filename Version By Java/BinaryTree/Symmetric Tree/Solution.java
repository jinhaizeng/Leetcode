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

/**
 * 第二种解题思路，从递归的角度入手解决问题
 * 递归的函数要判断的任务：判断一颗二叉树他的左右子树是否对称
 * 首先有一个误区：就是使用递归判断二叉树，照搬二叉树遍历的框架：将二叉树看成根节点、左子树、右子树三部分，判断根节点满不满足对称二叉树，
 * 然后递归的判断左子树和右子树是否满足对称二叉树
 * 以上思路主要的错因在于对对称二叉树的理解出了错对称二叉树，对称二叉树应该是基于中轴线对称，所以将大问题转化为小问题的正确方法是：
 * 第一层——判断根节点的左右子树是否对称，推向下一层
 * 判断下一层是否对称
 */

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || Hepler(root.left,root.right);
    }
    public boolean Hepler(TreeNode left,TreeNode right){
        //第一层递归
        if(left == null || right == null )
            return left == right;       //此处的处理十分的精髓，因为left==right==null的时候，此时不应该返回flase，所以必须剔除这种特殊情况
            //所以使用return lef == right;是一种十分巧妙的操作
        if(left.val != right.val)
            return false;
        //推向下一层的递归
        return Hepler(left.left,right.right)&&Hepler(left.right,right.left);
    }
}