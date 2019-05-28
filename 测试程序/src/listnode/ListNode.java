package listnode;



public class ListNode {
    public int val;
    public ListNode next;
    //无参的构造方法
    public ListNode(){}
    //带参的构造方法
    public ListNode(int x){
        val = x;
    }


    /**
     * 列表的建立函数：递归的方式；static关键保证可以直接使用类名调用方法
     * @param arr
     * @param num
     * @return
     */
    public static ListNode listBulid(int[] arr ,int num){
        if(num >= arr.length)
            return null;
        ListNode node = new ListNode(arr[num]);
        node.next = listBulid(arr,num+1);
        return node;
    }

    /**
     * 列表的打印：递归的方式
     * @param list
     */
    public static void listPrint(ListNode list){
        if(list == null)
            return;
        System.out.println(list.val);
        listPrint(list.next);
    }

}
