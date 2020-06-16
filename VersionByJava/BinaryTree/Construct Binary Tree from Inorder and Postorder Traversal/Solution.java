/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//方法一:最笨的方法，利用中序遍历和后序遍历，慢慢划分找到根节点，然后划分子树，然后继续找子树的根节点，依次往复得到最终的后果。
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = buildTreeHelp(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
        return root;
        
    }
    public TreeNode buildTreeHelp(int[] in,int inStart,int inEnd,int[] post,int postStart,int postEnd){
        //利用递归首先要写出递归的结束条件，本题的遍历是inStart、inEnd、postStart、postEnd
        //所以不妨从这个角度入手考虑递归的终止条件
        if(inStart > inEnd || postStart > postEnd)
            return null;
        TreeNode root = new TreeNode(post[postEnd]);    
        for(int i=inStart; i <= inEnd; ++i){
            if(in[i] == post[postEnd]){
                root.left = buildTreeHelp(in,inStart,i-1,post,postStart,postStart+i-inStart-1);
                root.right = buildTreeHelp(in,i+1,inEnd,post,postStart+i-inStart,postEnd-1);
            }
        }
        return root;
    }
}

//方法二：基本思想与第一个相同，不过增加了一点点封装的思想，基础部分不拓展了，快速完成这一块，抓紧时间不要拖拖拉拉。