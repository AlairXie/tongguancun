package com.example.tongguancun.chapter2_reverselist.level3;

import com.example.tongguancun.Commom.InitList;
import com.example.tongguancun.Commom.Node;

/**
 * k个一组反转
 */
public class ReverseListKGrpoup {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        Node nodeA = InitList.initLinkedList(a);

        Node d = null;
        int testMethod = 1;
        switch (testMethod) {
            case 1://方法1：穿针引线法
                d = reverseKGroup(nodeA, 3);
                break;
            case 2://方法2：头插法+递归
                d = reverseListKGroupByHead(nodeA, 3);
                break;

        }


        System.out.println(InitList.toString(d));

    }

    //方法：头插法+递归
    public static Node reverseListKGroupByHead(Node head, int k) {
        Node dummyHead = new Node(-1);
        dummyHead.next = head;
        Node cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }

        int n = len / k;
        Node pre = dummyHead;
        cur = head;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k - 1; j++) {
                Node next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = cur;
            cur = cur.next;

        }
        return dummyHead.next;
    }

    //方法：穿针引线法
    public static Node reverseKGroup(Node head, int k) {
        Node dummyHead = new Node(0);
        dummyHead.next = head;

        Node pre = dummyHead;
        Node end = dummyHead;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }

            if (end == null) {
                break;
            }

            Node start = pre.next;
            Node next = end.next;
            end.next = null;

            pre.next = reveseNode(start);

            start.next = next;
            pre = start;
            end = pre;


        }
        return dummyHead.next;
    }


    public static Node reveseNode(Node head) {
        Node dummyHead = new Node(-1);
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = dummyHead.next;
            dummyHead.next = cur;
            cur = next;

        }
        return dummyHead.next;
    }
}
