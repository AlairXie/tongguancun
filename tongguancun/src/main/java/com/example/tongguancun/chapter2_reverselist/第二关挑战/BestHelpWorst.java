package com.example.tongguancun.chapter2_reverselist.第二关挑战;


/**
 * @Author xieyunpeng
 * @Date 2023/12/11 11:47
 */
public class BestHelpWorst {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node nodeA = initLinkedList(a);

        Node d = bestHelpWorst(nodeA);

        System.out.println(toString(d));

    }


    public static Node bestHelpWorst(Node head) {
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node cur = head;
        Node cur1 = dummy1;
        Node cur2 = dummy2;
        int i = 1;
        // 拆表
        while(cur != null){
            if(i % 2 != 0){
                cur1.next = cur;
                cur1 = cur1.next;
                cur = cur.next;
                cur1.next = null;
            }else {
                cur2.next = cur;
                cur2= cur2.next;
                cur = cur.next;
                cur2.next = null;
            }
            i++;
        }

        // 反转偶数链表
        cur2 = reverseNode(dummy2.next);

        // 合并
        cur1 = dummy1.next;

        while(cur1 != null && cur2 != null){
            Node next1 = cur1.next;
            Node next2 = cur2.next;

            cur1.next = cur2;
            cur2.next = next1;

            cur1 = next1;
            cur2 = next2;
        }

        return dummy1.next;
            
    }

    public static Node reverseNode(Node head) {
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

    static class Node {
        public int val;
        public Node next;

        public Node(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return "Node{" + "val=" + val + ", next=" + next + '}';
        }

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
