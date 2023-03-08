
//题目链接：https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/solutions/103069/mian-shi-ti-09-yong-liang-ge-zhan-shi-xian-dui-l-3/

import java.util.*;
class CQueue {
    // 注意这种写法不是线程安全的
    private Stack<Integer> stack_input; // 输入队列，appendTail的时候往里丢
    private Stack<Integer> stack_output; // 输出队列，deleteHead的时候从这里取，没有的时候，就从输入队列里先拿
    public CQueue() {
        stack_input = new Stack<Integer>();
        stack_output = new Stack<Integer>();
    }
    
    public void appendTail(int value) {
        stack_input.push(value);
    }
    
    public int deleteHead() {
        if (stack_output.empty()) {
            while(!stack_input.empty()) {
                // block1: 怎么样不破坏输入队列然后把数据塞到输出队列
                // 完全可以破坏，反正输入队列也用不到了
                stack_output.push(stack_input.pop());
            }
        }
        
        return stack_output.empty() ? -1 : stack_output.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */