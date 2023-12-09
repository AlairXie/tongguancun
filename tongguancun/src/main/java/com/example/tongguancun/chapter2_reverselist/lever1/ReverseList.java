package com.example.tongguancun.chapter2_reverselist.lever1;

import com.example.tongguancun.chapter2_reverselist.Commom.InitList;
import com.example.tongguancun.chapter2_reverselist.Commom.Node;

/**
 * 反转链表
 *
 * 带虚拟头结点方法是很多底层源码使用的，而不使用带头结点的方法是面试经常要考的，所以两种方式我们都要好好掌握。
 */
public class ReverseList {

    public static void main(String[] args) {
        int[] a = {4, 3, 2, 1};
        Node nodeA = InitList.initLinkedList(a);
        Node d = null;
        int testMethod = 3;
        switch (testMethod) {
            case 1: //方法1：虚拟结点，,并复用已有的结点
                d = reverseListByDummyNotCreate(nodeA);
                break;
            case 2: //方法2：不适用虚拟结点的反转方法
                d = reverseListSimple(nodeA);
                break;
            case 3: // 方法3 ：递归
                d = reverseListByRecurse(nodeA);
        }

        System.out.println(InitList.toString(d));

    }

    /**
     * 头插法（虚拟节点）反转
     */
    public static Node reverseListByDummyNotCreate(Node head){
        Node dummyHead = new Node(-1);
        Node cur = head;
        while(cur != null){
            Node next = cur.next;
            cur.next = dummyHead.next;
            dummyHead.next = cur;
            cur = next;

        }
        return dummyHead.next;
    }

    /**
     * 原地反转（不用虚拟节点）
     */
    public static Node reverseListSimple(Node head){
        Node cur = head;
        Node pre = null;
        while(cur != null){
            Node next = cur.next; // 保留下一个节点
            cur.next = pre; // 当前节点指向前节点
            pre = cur; // 更新前节点
            cur = next; // 更新当前节点

        }
        return pre;
    }


    /**
     * 递归
     */
    public static Node reverseListByRecurse(Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node newHead = reverseListByRecurse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
