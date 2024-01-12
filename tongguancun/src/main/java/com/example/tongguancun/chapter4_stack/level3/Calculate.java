package com.example.tongguancun.chapter4_stack.level3;

import java.util.Stack;

/**
 * @Author xieyunpeng
 * @Date 2024/1/12 17:21
 */
public class Calculate {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char perSign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1){
                switch (perSign){
                    case '+' : stack.push(num);break;
                    case '-' : stack.push(-num);break;
                    case '*' : stack.push(stack.pop()*num);break;
                    case '/' : stack.push(stack.pop() / num);break;
                }
                perSign = c;
                num = 0;
            }
        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
}
