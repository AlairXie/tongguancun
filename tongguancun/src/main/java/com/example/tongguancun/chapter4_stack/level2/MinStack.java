package com.example.tongguancun.chapter4_stack.level2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author xieyunpeng
 * @Date 2024/1/12 16:56
 */
public class MinStack {
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    Deque<Integer> xstack;
    Deque<Integer> minStack;
        public MinStack() {
            xstack = new LinkedList<>();
            minStack = new LinkedList<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            xstack.push(val);
            minStack.push(Math.min(minStack.peek(),val));
        }

        public void pop() {
            xstack.pop();
            minStack.pop();

        }

        public int top() {
            return xstack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }



}
