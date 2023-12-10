package com.example.tongguancun.chapter2_reverselist.level2.topic2_2两两反转;

import com.example.tongguancun.Commom.InitList;
import com.example.tongguancun.Commom.Node;

/**
 * lc 24
 */
public class ReverseListTwoGroup {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        Node nodeA = InitList.initLinkedList(a);

        Node d = null;
        d=swapPairs(nodeA);

        System.out.println(InitList.toString(d));

    }
    
    
    public static Node swapPairs(Node head){
        Node dummyHead = new Node(-1);
        dummyHead.next = head;
        Node temp = dummyHead;
        while(temp.next != null && temp.next.next != null){
            Node left = temp.next;
            Node right = temp.next.next;
            temp.next = right;
            left.next = right.next;
            right.next = left;
            temp = left;

        }
        return dummyHead.next;
    }
}
