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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int levelNum = 1;
        int num = 0;
        ArrayList<Integer> levelList = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            root = queue.remove();
            if (root.left != null) {
                queue.offer(root.left);
                levelList.add(root.left.val);
            } else {
                levelList.add(Integer.MIN_VALUE);
            }
            if (root.right != null) {
                queue.offer(root.right);
                levelList.add(root.right.val);
            } else {
                levelList.add(Integer.MIN_VALUE);
            }
            
            num += 2;

            if (num == levelNum) {
                num = 0;
                levelNum *= 2;
                if (!isMir(levelList)) {
                    return false;
                }
                levelList.clear();
            }  
        }
        return true;
    }

    public boolean isMir(ArrayList list) {
        int length = list.size();
        if (length%2 == 1) {
            return false;
        }
        for (int i=0; i < length/2; ++i) {
            System.out.println("i: " + i + ", list: " + list.get(i));
            if (!list.get(i).equals(list.get(length - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}