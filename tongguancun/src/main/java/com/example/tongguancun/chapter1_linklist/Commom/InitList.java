package com.example.tongguancun.chapter1_linklist.Commom;

/**
 * @Author xieyunpeng
 * @Date 2023/12/4 11:15
 */
public class InitList {
    /**
     * 简单构造两个链表
     *
     * @return
     */
    public static Node[] initLinkedList() {
        Node[] heads = new Node[2];
//        构造第一个链表交点之前的元素 1 ->2-> 3
        heads[0] = new Node(1);
        Node current1 = heads[0];
        current1.next = new Node(2);
        current1 = current1.next;
        current1.next = new Node(3);
        current1 = current1.next;
//        11->22
//        构造第二个链表交点之前的元素
        heads[1] = new Node(11);
        Node current2 = heads[1];
        current2.next = new Node(22);
        current2 = current2.next;
//        构造公共交点以及之后的元素

        Node node4 = new Node(4);
        current1.next = node4;
        current2.next = node4;
        Node node5 = new Node(5);
        node4.next = node5;


        Node node6 = new Node(6);
        node5.next = node6;

        return heads;
    }


    public static Node initLinkedList(int[] array) {
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


    public static String toString(Node head) {
        Node current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.val).append("\t");
            current = current.next;
        }
        return sb.toString();
    }
}
