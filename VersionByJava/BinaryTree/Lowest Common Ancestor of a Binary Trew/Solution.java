/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//错误解法：留下来警醒未来
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)  
            return null;
        return lowestCommonAncestorHelper(root,p,q);
        
    }
    public TreeNode lowestCommonAncestorHelper(TreeNode root,TreeNode p ,TreeNode q){
        //首先先写递归终止条件
      
        //判断这个结点在左右子树中的哪一侧，同侧就继续递归
        if(root.left !=null && root.right != null){
            if((isExist(root.left,p)&&isExist(root.right,q)) || (isExist(root.left,q)&&isExist(root.right,p)))
            return root;
            else if(isExist(root.left,p) && isExist(root.left,q))
                return lowestCommonAncestorHelper(root.left,p,q);
            else if(isExist(root.right,p) && isExist(root.right,q))
                return lowestCommonAncestorHelper(root.right,p,q);
        }
        else if(root.left !=null && root.right == null){
            return lowestCommonAncestorHelper(root.left,p,q);
        }
        else if(root.left ==null && root.right != null){
            return lowestCommonAncestorHelper(root.right,p,q);
        }
            return null;
            
        
    }
    public boolean isExist(TreeNode root,TreeNode node){
        
        if(root.val == node.val)
            return true;
        if(root.left != null) isExist(root.left,node);
        if(root.right != null) isExist(root.right,node);
        return false;
    }
}

//正确的思路的解析
/**
 * 1.首先将整棵树抽象成根结点和左右子树
 * 2.抽象出函数的作用，本题函数的作用：找出两个结点的最近祖先
 * 3.判断终止条件：一个基本情况——为空直接返回空即可，两个特殊情况——p、q中有一个是根结点，那个这个节点就是另一个结点的祖先（叫爸爸）
 * 4.递归的遍历根结点和左右子树
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //首先写出终止条件
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null) return root;
        return left != null ?left:right;
    }
}