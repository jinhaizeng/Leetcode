
// 剑指 Offer 06. 从尾到头打印链表
// 题目链接：https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=xhmstdoe

/** 自己思路
 看到这题，自己的第一反应感觉有点像反转链表，不如和反转链表一起做把
 解题思路这一块，第一反应是借助stack实现：先用把数据存到stack里面，输出的就是逆序的，存在的问题是：需要两次遍历&需要额外的占用空间
 暂时没想到更好的方法
 */

 /** 参考答案
  答案给了一种新的思路，采用递归的方式，利用递归的栈来实现逆序输出数组
  */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> reverseResult = new ArrayList<Integer>();
        reverseList(reverseResult, head);
        // 这里还要转类型，太扯淡了，integer转int很扯，去看解题答案，发现还是老老实实遍历，别用java api了
        // Integer[] result = new Integer[reverseResult.size()];
        // reverseResult.toArray(result);

        int[] result = new int[reverseResult.size()];
        for(int i=0; i < reverseResult.size(); i++) {
            result[i] = (reverseResult.get(i));
        }
        return result;
    }
    public void reverseList(ArrayList<Integer> result, ListNode head) {
        if (head == null) {
            return;
        }
        reverseList(result, head.next);
        result.add(head.val);
    }
}