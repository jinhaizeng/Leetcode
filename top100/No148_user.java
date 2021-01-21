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
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) return head;
        //第一趟定位出链表的长度，并做一次排序
        int length = 0;
        int temp = 0;
        ListNode headPoint = head;
        while(headPoint.next != null) {
            if (headPoint.val > headPoint.next.val) {
                temp = headPoint.val;
                headPoint.val = headPoint.next.val;
                headPoint.next.val = temp;
            }
            headPoint = headPoint.next;
            length++;
        }
        for (int i=0; i < length; ++i) {
            headPoint = head;
            for (int j=0; j < length; ++j) {
                if (headPoint.val > headPoint.next.val) {
                    temp = headPoint.val;
                    headPoint.val = headPoint.next.val;
                    headPoint.next.val = temp;
                }
                headPoint = headPoint.next;
            }
        }
        return head;
    }
}