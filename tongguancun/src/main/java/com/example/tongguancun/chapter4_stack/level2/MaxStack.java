package com.example.tongguancun.chapter4_stack.level2;

import java.util.Stack;

/**
 * @Author xieyunpeng
 * @Date 2024/1/12 16:56
 */
public class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> maxStack;

    public MaxStack() {
        stack = new Stack();
        maxStack = new Stack();
        maxStack.push(Integer.MIN_VALUE);
    }

    public void push(int x) {
        maxStack.push(Math.max(maxStack.peek(), x));
        stack.push(x);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = peekMax();
        Stack<Integer> buffer = new Stack();
        while (top() != max) buffer.push(pop());
        pop();
        while (!buffer.isEmpty()) push(buffer.pop());
        return max;
    }

}
