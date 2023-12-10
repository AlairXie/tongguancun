package com.example.tongguancun.chapter2_reverselist.level2.topic2_3链表加1;

import com.example.tongguancun.Commom.InitList;
import com.example.tongguancun.Commom.Node;
import lombok.val;

/**
 * lc 369
 */
public class PlusOne {
    public static void main(String[] args) {
//        int[] a = {7, 8};
//        int[] a = {9,9,9};
        int[] a = {1, 2, 3};
        Node nodeA = InitList.initLinkedList(a);

        Node node = plusOne(nodeA);

        System.out.println(InitList.toString(node));

    }

    private static Node plusOne(Node head) {
        head = reverseNode(head);
        int carry = 0;
        Node cur = head;
        int addr = 1;
        int sum = 0;
        while(cur != null){
            sum = cur.val + addr + carry;
            carry = sum >= 10 ?  1 : 0 ;
            cur.val = sum % 10 ;
            addr = 0;
            if (cur.next == null && carry == 1){
                Node newNode = new Node(1);
                cur.next = newNode;
                break;
            }
            cur = cur.next;
        }
        head =  reverseNode(head);
        return head;
    }

    public static Node reverseNode(Node head){
        Node cur = head;
        Node pre = null;
        while(cur != null){
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

}
