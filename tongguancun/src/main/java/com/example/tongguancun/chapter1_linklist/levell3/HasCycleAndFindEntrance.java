package com.example.tongguancun.chapter1_linklist.levell3;

import com.example.tongguancun.Commom.InitList;
import com.example.tongguancun.Commom.Node;

public class HasCycleAndFindEntrance {
    /**
     * 是否存在环,如果存在环，要返回入口
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        Node nodeA = null;

        //构造链表是否存在环
        int isCycle = 2;
        switch (isCycle) {
            case 1://构造的链表中存在环
                nodeA = initLinkedListHasCycle(a);
                break;
            case 2://构造的链表中不存在环
                nodeA = InitList.initLinkedList(a);
                break;
        }


        //测试哪个方法
        int testmethod = 2;
        Node result = null;
        switch (testmethod) {
//            case 1:
//                result = detectCycleByMap(nodeA);
//                break;
            case 2:
                result = detectCycleByTwoPoint(nodeA);
                break;
        }

        System.out.println(result.val);

    }
    
    public static Node detectCycleByTwoPoint(Node head){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                fast = head;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
            
        }
        return null;
        
    }

    /**
     * 构造存在环的情况
     *
     * @param array
     * @return
     */
    private static Node initLinkedListHasCycle(int[] array) {
        Node head = null, cur = null;
        Node cross = null;
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
                    cross = cur;
                }
            }
        }
        //制造环
        cur.next = cross;
        return head;
    }
}
