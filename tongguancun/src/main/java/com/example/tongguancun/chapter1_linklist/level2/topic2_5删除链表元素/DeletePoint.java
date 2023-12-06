package com.example.tongguancun.chapter1_linklist.level2.topic2_5删除链表元素;

import com.example.tongguancun.Commom.InitList;
import com.example.tongguancun.Commom.Node;

/**
 * 删除特定节点
 */
public class DeletePoint {
    public static void main(String[] args) {
        int[] a = {4, 4, 5, 1, 9, 9};
        Node nodeA = InitList.initLinkedList(a);
        int testMethod = 2;
        switch (testMethod) {
//            case 1://LeetCode 237 删除给定结点
//                deleteTargetNode(nodeA.next);
//                break;
            case 2://LeetCode203 删除指定值的结点
                nodeA = deletePoint(nodeA, 4);
                break;
        }

        System.out.println(InitList.toString(nodeA));


    }

    // 删除特定值的节点
    public static Node deletePoint(Node head , int val){
        Node dummyHead = new Node(-1);
        dummyHead.next = head;
        Node cur = dummyHead;
        while(cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

}
