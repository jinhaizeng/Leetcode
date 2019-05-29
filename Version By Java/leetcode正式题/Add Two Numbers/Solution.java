/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//柳神的代码真的简洁，直接看方法三吧
//方法一：考虑到极端的情况，即两个列表不是等长的,考虑了下，要不然还是用递归解决吧
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

//方法二：采用非递归的做法
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //如果不加上下面的c1和c2，那么11和l2会随着不断的遍历，慢慢指向这个链表堆空间的最后一个结点
         ListNode c1 = l1;
         ListNode c2 = l2;
        //建两个对象，d和sentinel都指向头结点， 如果没有d的话，每次进行sentinel = sentinel.next会变成，sentinal栈空间对应的
        //堆空间地址在不断的更新，逻辑上的表现就是sentinel不停的往后指，这样虽然结点成链了，但是头结点却找不到了，结果没有意义。
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while(c1 !=null || c2 != null){
            sum /= 10;      //取出上一次计算的进位符
            if(c1 != null ){
                sum += c1.val;
                c1 = c1.next;
            }
            if(c2 != null){
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        //上述遍历还少了一种特殊情况的讨论：即进位符为1，但是c1和c2都为空的情况
        if(sum/10 == 1){
            d.next = new ListNode(sum/10);
        }

        //一定要注意，这个链表相当于带头结点的链表，返回的结果要去掉头结点
        return sentinel.next;
    }
}

//方法三：柳神的代码，吃完饭以后回来写，不然现在没有理清思路都是直接看的代码得出的结果
