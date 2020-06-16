/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 第一种方法，递归法，使用list作为返回值
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre = new LinkedList<Integer>();
        if(root == null)    //递归循环终止条件（这个是重中之重，老是容易被忽略）
            return pre;
        //从递归的角度看整个函数，根节点加入List，再左子树加入List，最后右子树加入List
        pre.add(root.val);
        pre.addAll(preorderTraversal(root.left));
        pre.addAll(preorderTraversal(root.right));
        return pre;
    }

    //第二种方法，还是递归的方法，但是用prehelp这个方法，传入一个list，而不用在递归的时候每次都实例化一个list
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> pre = new LinkedList<Integer>();
        preHelper(root,pre);
        return pre;
    }
    public void preHelper(TreeNode root,List pre){
        if(root == null)
            return ;
        pre.add(root.val);
        preHelper(root.left,pre);
        preHelper(root.right,pre);
    }

    //第三种方法，利用栈的思路，看下天勤再做决定
}

