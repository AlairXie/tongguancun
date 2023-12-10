package com.example.tongguancun.chapter1_linklist.level2.topic2_2判断链表是否为回文序列;

import com.example.tongguancun.Commom.Node;

import java.util.Stack;

/**
 * @author xieyunpeng
 * @create 2023/12/3
 */
public class IsPalindromic {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 4, 3, 2, 1};
        Node node = initLinkedList(a);
        int testMethod = 2;
        boolean result = false;
        switch (testMethod) {
            case 1://方法1：通过双指针的方式来判断
//                result = isPalindromeByTwoPoints(node);
                break;
            case 2: //方法2：全部压栈
                result = isPalindromeByAllStack(node);
                break;
            case 3://方法3：只将一半的数据压栈
//                result = isPalindromeByHalfStack(node);
                break;
            case 4://方法4：通过递归来实现
//                result = isPalindromeByRe(node);
                break;

        }
        System.out.println("result:" + result);
    }

    /**
     *   1、数组+双指针（这种方法会被视为逃避链表，面试不能这么干）
     */


    /**
     * 全部压栈
     * 1、全部元素压栈
     * 2、一边出栈。一边遍历原链表
     */
    public static boolean isPalindromeByAllStack(Node head){

        // 1、全部元素压栈
        Stack<Integer> stack = new Stack<>();
        Node cur = head;
        while(cur != null){
            stack.push(cur.val);
            cur = cur.next;
        }

        //2、一边出栈。一边遍历原链表
        while(head != null){
            if(stack.pop() != head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }


    /**
     *   反转链表法
     */




    private static Node initLinkedList(int[] array) {
        Node head = null, cur = null;
        for (int i = 0; i < array.length; i++) {
            Node newNode = new Node(array[i]);
            newNode.next = null;
            if (i == 0) {
                head = newNode;
                cur = head;
            } else {
                cur.next = newNode;
                cur = newNode;
            }
        }
        return head;
    }

}
