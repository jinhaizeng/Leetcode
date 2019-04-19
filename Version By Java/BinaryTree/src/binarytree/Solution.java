package binarytree;

import java.util.List;
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

    public List<Integer> preorderTraversal(TreeNode root) {
        preorderTraversal(root.left);
//        if(root)
//            return root.val;
        preorderTraversal(root.right);

    }
}
