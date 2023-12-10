package com.example.tongguancun.chapter2_reverselist.level2.topic2_4链表加法;

import com.example.tongguancun.Commom.InitList;
import com.example.tongguancun.Commom.Node;

/**
 * @author xieyunpeng
 * @create 2023/12/10
 */
public class TwoNodeListAdd {
    public static void main(String[] args) {
        int[] a = {1,8};
        Node nodeA = InitList.initLinkedList(a);
//        int[] b = {1,2};
        int[] b = {1,2};
//        int[] b = {1,8,2};
        Node nodeB = InitList.initLinkedList(b);

        Node d = null;
        int testMethod = 3;
        switch (testMethod) {
//            case 1://方法1：通过栈实现
//                d = addInListByStack(nodeA, nodeB);
//                break;
            case 2://方法2：通过链表反转来实现
                d = twoNodeListAdd(nodeA, nodeB);
                break;
            case 3://方法2：通过链表反转来实现
                d = addIntList(nodeA, nodeB);
                break;

        }


        System.out.println(InitList.toString(d));

    }

    // 代码复杂
    public static Node twoNodeListAdd(Node head1 , Node head2){
        Node dummyHead = new Node(-1);
        Node cur = dummyHead;
        head1 = reveseNode(head1);
        head2 = reveseNode(head2);
        Node cur1 = head1;
        Node cur2 = head2;
        int sum = 0;
        int carry = 0;
        while(cur1 != null && cur2 != null){
            sum = cur1.val + cur2.val + carry;
            carry  = sum / 10;
            Node newNode = new Node(sum % 10);
            cur.next = newNode;
            cur = cur.next;
            if (cur1.next == null && cur2.next == null && carry == 1){
                Node node2 = new Node(1);
                cur.next = node2;
                cur = cur.next;
                break;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        while(cur1 != null){
            Node node = new Node(0);
            if(carry == 1){
                sum = cur1.val + carry;
                node.val = sum % 10;
            }else {
                node.val = cur1.val;
            }
            cur.next = node;
            cur = cur.next;
            cur1 = cur1.next;

        }

        while(cur2 != null){
            Node node = new Node(0);
            if(carry == 1){
                sum = cur2.val + carry;
                node.val = sum % 10;
            }else {
                node.val = cur2.val;
            }
            cur.next = node;
            cur = cur.next;
            cur2 = cur2.next;

        }
        return reveseNode(dummyHead.next);

    }

    // 优化算法
    public static Node addIntList(Node head1 , Node head2){
        Node dummyHead = new Node(-1);
        Node cur = dummyHead;
        head1 = reveseNode(head1);
        head2 = reveseNode(head2);
        Node cur1 = head1;
        Node cur2 = head2;
        int sum = 0;
        int carry = 0;
        while(cur1 != null || cur2 != null){
            sum = carry;
            if (cur1 != null){
                sum += cur1.val;
                cur1 = cur1.next;
            }
            if (cur2 != null){
                sum += cur2.val;
                cur2 = cur2.next;

            }
            carry  = sum / 10;
            cur.next = new Node(sum % 10);
            cur = cur.next;

        }
        if(carry == 1){
            Node newNode = new Node(1);
            cur.next = newNode;
        }
        return reveseNode(dummyHead.next);

    }



    public static Node reveseNode(Node head){
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
}
