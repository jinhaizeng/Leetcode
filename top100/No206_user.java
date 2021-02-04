/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// 迭代写法
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode fakeHead = new ListNode();
        ListNode temp = null;
        while (head != null) {
            temp = head.next;
            head.next = fakeHead.next;
            fakeHead.next = head;
            head = temp.next;
        }
        return fakeHead.next;
    }
}

// 递归写法
class Solution1 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ReverseList(head.next);
        ListNode temp = head.next
    }
}