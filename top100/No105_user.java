/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.Arrays;
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    public TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if(preStart > preorder.length-1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = null;
        root.right = null;
        int index = find(inorder, preorder[preStart]);
        System.out.println("index: " + index);
        if (index < inStart || index > inEnd) {
            return root;
        }
        int leftNum = index - inStart;
        if (leftNum > 0) {
            root.left = build(preorder, inorder, preStart+1, preStart+leftNum, inStart, index-1);
        }
        if (inEnd > index) {
            root.right = build(preorder, inorder, preStart+1+leftNum, preEnd, index+1, inEnd);
        }
        
        return root;
    }
    public int find(int[] nums, int target) {
        for (int i=0; i < nums.length; ++i) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}