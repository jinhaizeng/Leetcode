package addtwonumbers;
import listnode.*;


public class main {
    public static void main(String[] args) {
        int[] arr1 = {9,8};
        int[] arr2 = {1};
        //建立ListNode
        ListNode l1 = ListNode.listBulid(arr1,0);
        ListNode l2 = ListNode.listBulid(arr2,0);

        Solution obj = new Solution();
        ListNode result = obj.addTwoNumbers(l1,l2);
        ListNode.listPrint(result);

    }
}
