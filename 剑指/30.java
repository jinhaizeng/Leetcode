//题目链接：https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=xhmstdoe

/** 自己的思路
  看题目以后的思路：可以考虑用两个栈或者两个数组解决这个问题
  可以考虑用两个数组，一个数组就正常的存数据，另一个数组就存当前长度下的最小值
  每次push新元素的时候，数组1就正常存，数组2只需要比较下是不是比当前栈顶元素小，如果小的话，栈顶就是新元素，如果大的话，就是原栈顶元素
 */ 

 /** 更好的方法
  看了下题解，还有种不使用辅助栈，使用差值保存法
  */

import java.util.*;
class MinStack {
    private Stack<Integer> stackDefault;
    private Stack<Integer> stackMin;
    /** initialize your data structure here. */
    public MinStack() {
        stackDefault = new Stack<Integer>();
        stackMin = new Stack<Integer>();
    }
    
    public void push(int x) {
        stackDefault.push(x);
        if (stackMin.empty()) {
            stackMin.push(x);
        } else {
            int currentMin = stackMin.peek();
            if (currentMin > x) {
                stackMin.push(x);
            } else {
                stackMin.push(currentMin);
            }
        }
    }
    
    public void pop() {
        stackDefault.pop();
        stackMin.pop();
    }
    
    public int top() {
        return stackDefault.peek();
    }
    
    public int min() {
        return stackMin.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */