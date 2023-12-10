package com.example.tongguancun.chapter1_linklist.level2.topic2_4双指针;
import com.example.tongguancun.Commom.InitList;
import com.example.tongguancun.Commom.Node;

/**
 * 寻找链表倒数第K个结点
 */
public class GetKthFromEnd {


    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        Node nodeA = InitList.initLinkedList(a);
        Node node = getKthFromEnd(nodeA,1);
        System.out.println(node.val);
    }

    public static Node getKthFromEnd(Node head,int k){
        Node fast = head, slow = head;
        while(fast != null &&  k > 0){
            fast = fast.next;
            k--;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
