/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashMap<TreeNode, Integer> map = new HashMap(TreeNode, Integer);
        while(head != null) {
            if (map.containsKey(head)) {
                return true;
            } else {
                map.put(head, 1)
            }
        }
        return false;
    }
}