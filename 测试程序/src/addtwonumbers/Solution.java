package addtwonumbers;
import listnode.*;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return helper(l1,l2,0);

    }

    public ListNode helper(ListNode node1,ListNode node2,Integer CF){
        //递归停止条件：
        int val = 0;
        if(node1 == null && node2 == null && CF == 0){
            return null;
        }
        else if(node1 != null && node2 != null){
            val = (node1.val + node2.val + CF)%10;
            CF = (node1.val + node2.val +CF)/10;
        }
        else if(node1 == null && node2 != null){
            val = (node2.val+CF)%10;
            CF = (node2.val+CF)/10;
        }
        else if(node1 != null && node2 == null){
            val = (node1.val+CF)%10;
            CF = (node1.val+CF)/10;
        }
        else{
            val = 1;
            CF = 0;
        }


        ListNode node = new ListNode(val);
        if(node1 != null && node2 != null)
            node.next = helper(node1.next,node2.next,CF);
        if(node1 == null && node2 != null)
            node.next = helper(node1,node2.next,CF);
        if(node1 != null && node2 == null)
            node.next = helper(node1.next,node2,CF);
        if(node1 == null && node2 == null && CF == 1)
            node.next = new ListNode(1);

        return node;
    }
}
