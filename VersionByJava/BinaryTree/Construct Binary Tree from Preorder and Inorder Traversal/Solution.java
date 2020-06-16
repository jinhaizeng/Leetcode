/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 根据先序遍历和中序遍历的序列得到创建这么一颗树，思路和利用中户和后序创建是一样的，就是找到根节点，然后划分左右子树，依次迭代
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = buildTreeHelp(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        return root;
    }

    public TreeNode buildTreeHelp(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd){
        if(preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode node = new TreeNode(preorder[preStart]);
        for(int i=inStart; i <= inEnd;i++){             //不要做什么题都想着i从0开始赋值，要多动动脑子，i的取值范围是inStart~endStart
            if(inorder[i] == preorder[preStart]){
                node.left = buildTreeHelp(preorder,preStart+1,preStart+i-inStart,inorder,inStart,i-1);
                node.right = buildTreeHelp(preorder,preStart+i-inStart+1,preEnd,inorder,i+1,inEnd);
            }
        }
        return node;
    }
}