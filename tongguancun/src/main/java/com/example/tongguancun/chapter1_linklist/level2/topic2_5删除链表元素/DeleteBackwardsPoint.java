package com.example.tongguancun.chapter1_linklist.level2.topic2_5删除链表元素;

import com.example.tongguancun.chapter1_linklist.Commom.InitList;
import com.example.tongguancun.chapter1_linklist.Commom.Node;

/**
 * 删除倒数的特定节点
 */
public class DeleteBackwardsPoint {

    /**
     * 几个与倒数有关的问题
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {4, 4, 5, 1, 9, 9};
        Node nodeA = InitList.initLinkedList(a);
        int testMethod = 4;
        Node result = null;
        switch (testMethod) {
//            case 1://找链表的倒数第K个元素开始的链表
//                result = getKthFromEnd(nodeA, 3);
//                break;
//            case 2:
//                result = removeNthFromEndByLength(nodeA, 3);
//                break;
//            case 3:
//                result = removeNthFromEndByStack(nodeA, 3);
//                break;
//            case 4:
//                result = removeNthFromEndByTwoPoints(nodeA, 3);
//                break;  

            case 4:
                result = deleteBackwardsPoint(nodeA, 7);
                break;

        }

        System.out.println(InitList.toString(result));


    }

    // slow往前一个元素，再同时移动n位就可以找到，要移除元素的前一位
    public static Node deleteBackwardsPoint(Node head, int n) {
        Node dummyHead = new Node(0);
        dummyHead.next = head;
        Node fast = head;
        Node slow = dummyHead;
        while (fast != null && n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
            slow.next = slow.next.next;
        return dummyHead.next;
    }
}
