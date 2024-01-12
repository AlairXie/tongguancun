package com.example.tongguancun.chapter4_stack.level2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author xieyunpeng
 * @Date 2024/1/11 19:36
 */
public class IsValid {

    public static void main(String[] args) {
//        String s = "()[]{}";
//        String s = "()";
        String s = "}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s){
        Map<Character,Character> map = new HashMap<>();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                stack.push(c);
            }else {
                if (!stack.isEmpty()){
                    char left = stack.pop();
                    char right = map.get(left);
                    if (right!= c){
                        return false;
                    }
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
