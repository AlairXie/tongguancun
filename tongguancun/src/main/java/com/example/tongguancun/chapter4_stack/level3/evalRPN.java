package com.example.tongguancun.chapter4_stack.level3;

import org.springframework.data.relational.core.sql.In;
import org.springframework.util.StringUtils;

import javax.xml.stream.events.Characters;
import java.util.Stack;

/**
 * @author xieyunpeng
 * @create 2024/1/12
 */
public class evalRPN {
    public static void main(String[] args) {
       String[] tokens1 = {"2","1","+","3","*"};
       String[] tokens2 = {"4","13","5","/","+"};
       String[] tokens3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};

//        System.out.println(evalRPN(tokens1));
//        System.out.println(evalRPN(tokens2));
        System.out.println(evalRPN(tokens3));

    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if (!Character .isDigit(s.charAt(0)) && s.length() == 1){
                    int second = stack.pop();
                    int first = stack.pop();
                    switch (s){
                        case "+" : stack.push( first + second ) ;break;
                        case "-" : stack.push( first - second ) ;break;
                        case "*" : stack.push( first * second ) ;break;
                        case "/" : stack.push( first / second ) ;break;
                    }
            }else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
