package com.example.tongguancun.chapter5_map_queue.level2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author xieyunpeng
 * @Date 2024/1/15 20:23
 */
public class MyQueue {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public MyQueue() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    public void push(int x) {
        inStack.push(x);

    }

    public int pop() {
        if (outStack.isEmpty()){
            in2out();
        }
        return outStack.pop();
    }


    public int peek() {
        if (outStack.isEmpty()){
            in2out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2out(){
        while(!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
    }

}
