package com.example.tongguancun.chapter1_linklist.level2.topic2_4双指针;

import com.example.tongguancun.Commom.InitList;
import com.example.tongguancun.Commom.Node;

/**
 * 旋转链表
 */
public class RotateRight {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        Node nodeA = InitList.initLinkedList(a);
        Node node = rotateRight(nodeA, 2);
        System.out.println(toString(node));
    }


    public static Node rotateRight(Node head ,int k){
        if(head == null || k == 0){
            return head;
        }
        Node tmp = head;
        Node fast = head , slow = head ;
        int len = 0;

        while(tmp != null){
            tmp = tmp.next;
            len++;
        }
        if(k % len == 0){
            return head;
        }
        while (fast != null  && (k % len) > 0){
            fast = fast.next;
            k--;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        Node res = slow.next;

        fast.next = head;
        slow.next = null;

        return res;
    }



    /**
     * 输出链表
     *
     * @param head 头节点
     */
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
