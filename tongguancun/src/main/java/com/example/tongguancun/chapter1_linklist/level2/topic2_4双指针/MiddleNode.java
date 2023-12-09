package com.example.tongguancun.chapter1_linklist.level2.topic2_4双指针;

import com.example.tongguancun.chapter1_linklist.Commom.InitList;
import com.example.tongguancun.chapter1_linklist.Commom.Node;

/**
 * 寻找中间节点
 * leetcode 876
 */
public class MiddleNode {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        Node nodeA = initLinkedList(a);
        Node middle = middleNode(nodeA);
        System.out.println(middle.val);
    }

    public static Node middleNode(Node head){
        Node fast = head,slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }


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
