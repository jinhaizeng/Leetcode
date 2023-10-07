
## 递归写法
```java
import java.util.*;
/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        travel(listNode, result);
        return result;
    }

    public ArrayList<Integer> travel(ListNode listNode, ArrayList<Integer> result) {
        if (listNode == null) return result;
        travel(listNode.next, result);
        result.add(listNode.val);
        return result;
    }
}
```

### 栈写法
```java
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<Integer> nodeStack = new Stack<Integer>();
        ListNode cur = listNode;
        while(cur != null) {
            nodeStack.push(cur.val);
            cur = cur.next;
        }
        while(!nodeStack.isEmpty()) {
            result.add(nodeStack.pop());
        }
        return result;
    }
}
```