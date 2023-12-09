package com.example.tongguancun.chapter1_linklist.level2.topic2_5删除链表元素;

import com.example.tongguancun.chapter1_linklist.Commom.InitList;
import com.example.tongguancun.chapter1_linklist.Commom.Node;

/**
 * 删除重复节点
 */
public class DeleteDuplatePoint {
    /**
     * 删除重复元素的问题
     *
     * @param args
     */
    public static void main(String[] args) {
//        int[] a = {1, 2, 3, 3, 4, 4, 5,6,6,6,6,7};
        int[] a = {1, 1,1};
        Node nodeA = InitList.initLinkedList(a);
        int testMethod = 2;
        Node result = null;
        switch (testMethod) {
            case 1://重复元素保留一个
                result = deleteDuplatePoint(nodeA);
                break;
            case 2:
                result = deleteDuplatePoints(nodeA);
                break;
        }

        System.out.println(InitList.toString(result));


    }

    //重复元素保留一个
    public static Node deleteDuplatePoint(Node head ){
        Node dummyHead = new Node(0);
        dummyHead.next = head;
        Node cur = dummyHead;
        while(cur.next != null){
            if (cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }

        }
        return dummyHead.next;
    }

    //重复元素都不要
    public static Node deleteDuplatePoints(Node head ){
        Node dummyHead = new Node(0);
        dummyHead.next = head;
        Node cur = dummyHead;
        while(cur.next != null && cur.next.next != null){
            if (cur.next.val == cur.next.next.val){
                int x = cur.next.val;
                while(cur.next != null && cur.next.val == x){
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next;
            }

        }
        return dummyHead.next;
    }
}
