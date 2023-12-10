package com.example.tongguancun.chapter1_linklist.levell3;

import com.example.tongguancun.Commom.InitList;
import com.example.tongguancun.Commom.Node;

/**
 * 判断是否存在环
 */
public class HasCycle {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        Node nodeA = null;

        //构造链表是否存在环
        int isCycle = 1;
        switch (isCycle) {
            case 1://构造的链表中存在环
                nodeA = initLinkedListHasCycle(a);
                break;
            case 2://构造的链表中部不存在环
                nodeA = InitList.initLinkedList(a);
                break;
        }


        //测试哪个方法
        int testmethod = 2;
        boolean result = false;
        switch (testmethod) {
//            case 1:
//                result = hasCycleByMap(nodeA);
//                break;
            case 2:
                result = hasCycleByTwoPoint(nodeA);
                break;
        }

        System.out.println(result);

    }
    
    
    /**
     * 判断是否存在环
     *
     */
    public static boolean hasCycleByTwoPoint(Node head){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
        
    }

    /**
     * 构造存在环的情况
     *
     * @param array
     * @return
     */
    private static Node initLinkedListHasCycle(int[] array) {
        Node head = null, cur = null;
        Node corss = null;
        for (int i = 0; i < array.length; i++) {
            Node newNode = new Node(array[i]);
            newNode.next = null;
            if (i == 0) {
                head = newNode;
                cur = head;
            } else {
                cur.next = newNode;
                cur = newNode;
                //找到中间位置结点
                if (i == array.length / 2) {
                    corss = cur;
                }
            }
        }
        //制造环
        cur.next = corss;
        return head;
    }
}
