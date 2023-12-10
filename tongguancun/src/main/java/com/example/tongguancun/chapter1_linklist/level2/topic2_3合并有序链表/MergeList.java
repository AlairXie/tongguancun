package com.example.tongguancun.chapter1_linklist.level2.topic2_3合并有序链表;

import com.example.tongguancun.Commom.Node;

/**
 * @author xieyunpeng
 * @create 2023/12/3
 */
public class MergeList {
    public static void main(String[] args) {
        int[] a = {1, 5, 8, 12};
        Node nodeA = initLinkedList(a);
        int[] b = {2, 5, 9, 13};
        Node nodeB = initLinkedList(b);
        int[] c = {3, 6, 10, 14};
        Node nodeC = initLinkedList(c);
        Node[] array = {nodeA, nodeB, nodeC};
        Node d = null;

        int[] e = {1, 2, 3, 4, 5, 6};
        Node nodeD = initLinkedList(e);
        System.out.println(middleNode(nodeD).val);

        int testMethod = 5;
        switch (testMethod) {
//            case 1://最直接的方法
//                d = mergeTwoLists2(nodeA, nodeB);
//                break;
            case 2://简化方法1中的方法
                d = mergeTwoListsMoreSimple(nodeA, nodeB);
                break;
//            case 3://通过递归方式来实现
//                d = mergeTwoListsByRe(nodeA, nodeB);
//                break;
            case 4://测试K个链表合并
                d = mergeKLists(array);
                break;
            case 5://合并两个链表（从中间合并）
                d = mergeInBetween(nodeA,1,3,nodeB);
                break;
        }


        System.out.println(toString(d));

    }


    /**
     * 合并k个链表
     * 两两合并，再与第三个链表两两合并，核心代码是两两合并
     *
     * @param nodeList
     * @return
     */
    public static Node mergeKLists(Node[] nodeList) {
        Node res = null;
        for (Node node : nodeList) {
            res = mergeTwoListsMoreSimple(res, node);
        }
        return res;

    }

    /**
     * 合并两个有序链表
     * 两个有序链表合并，不断遍遍历两个有序链表，取最小的值放入新链表
     * 还有剩余的链表直接合并到结尾
     *
     * @param head1
     * @param head2
     * @return
     */
    public static Node mergeTwoListsMoreSimple(Node head1, Node head2) {
        Node newNode = new Node(-1);
        Node newHead = newNode;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                newHead.next = head1;
                head1 = head1.next;
            } else {
                newHead.next = head2;
                head2 = head2.next;
            }
            newHead = newHead.next;

        }
        newHead.next = head1 == null ? head2 : head1;
        return newNode.next;
    }


    /**
     * 合并两个链表（从中间合并）
     * a , b 为下标
     * 力扣1669
     *
     * @return
     */

    public static Node mergeInBetween(Node list1, int a, int b, Node list2) {
        Node first = list1; // 前段的尾部
        Node second = list1; //后段的前端
        Node tail = list2; // 链表二的尾部
        int i = 0,j= 0;
        while(first != null && second != null && j < b){
            if(i != a - 1){
                first = first.next;
                i++;
            }
            if (j != b){
                second = second.next;
                j++;
            }
        }

        second = second.next; // 边界条件要往后推一位

        while (tail != null && tail.next != null) {
            tail = tail.next;
        }
        first.next = list2;
        tail.next = second;
        return list1;


    }

    public static Node middleNode(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
