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
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean isFirst = true;
        //先找相遇点
        while(slow != fast || isFirst) {
            isFirst = false;
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        //寻找入口节点
        ListNode headPtr = head;
        while (headPtr != slow) {
            headPtr = headPtr.next;
            slow = slow.next;
        }
        return headPtr;
    }
}