package com.example.tongguancun.chapter2_reverselist.level2.topic2_1指定区间反转;

import com.example.tongguancun.Commom.InitList;
import com.example.tongguancun.Commom.Node;

/**
 * 指定区间反转
 */
public class ReverseListBetween {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        Node nodeA = InitList.initLinkedList(a);

        Node d = null;
        int testMethod = 1;
        switch (testMethod) {
            case 1://方法1：穿针引线法
                d = reverseBetween(nodeA, 2, 4);
                break;
            case 2://方法2：头插法
                d = reverseBetween2(nodeA, 2, 4);
                break;

        }


        System.out.println(InitList.toString(d));

    }



    /**
     * 头插法
     * @return
     */
    public static Node reverseBetween2(Node head, int left , int right){
        Node dummyHead = new Node(-1);
        dummyHead.next = head;
        Node pre = dummyHead;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        Node cur = pre.next;
        for (int i = 0; i < right - left; i++) {
            Node next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummyHead.next;
    }

    /**
     * 穿针引线法
     */
    public static Node reverseBetween(Node head , int left , int right){
        Node dummyHead = new Node(-1);
        dummyHead.next = head;
        Node pre = dummyHead;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        Node leftNode = pre.next;
        Node rightNode = leftNode;
        for (int i = 0; i < right - left ; i++) {
            rightNode = rightNode.next;
        }

        Node succ = rightNode.next;
        rightNode.next = null;
        reverseNode(leftNode);

        pre.next = rightNode;
        leftNode.next = succ;

        return dummyHead.next;
    }

    private static void reverseNode(Node head) {
        Node cur = head;
        Node pre = null;
        while(cur != null){
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

        }
    }

}
