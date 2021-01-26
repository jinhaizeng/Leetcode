/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        //暴力解法
        while (pA != null) {
            while(pB != null) {
                if (pA == pB) {
                    return pA;
                }
                pB = pB.next;
            }
            pB = headB;
            pA = pA.next;
        }
        return null; 
    }
}