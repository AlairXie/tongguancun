package com.example.tongguancun.chapter1_linklist.level2.topic2_1第一个公共节点;

import com.example.tongguancun.chapter1_linklist.level2.Node;

import java.util.*;

/**
 * @author xieyunpeng
 * @create 2023/12/3
 *
 *
 *
 *
 */
public class FindFirstCommonNode {

    // 测试案例
    public static void main(String[] args) {
        Node[] heads = initLinkedList();
        //la 为 1 2 3 4 5
        //lb 为 11 22 4 5
        Node la = heads[0];
        Node lb = heads[1];



        int testMethod = 3;
        Node node = new Node(0);
        switch (testMethod) {
            case 1: //方法1：通过Hash辅助查找
                node = findFirstCommonNodeByMap(la, lb);
                break;
            case 2: //方法2：通过集合辅助查找
                node = findFirstCommonNodeBySet(la, lb);
                break;
            case 3://方法3：通过栈辅助查找
                node = findFirstCommonNodeByStack(la, lb);
                break;
//            case 4://方法4：通过拼接辅助查找
//                node = findFirstCommonNodeByCombine(la, lb);
//                break;
//            case 5://方法5：通过差辅助查找
//                node = findFirstCommonNodeBySub(la, lb);
//                break;
        }

        System.out.println("公共结点为：" + node.val);
    }



    // 方法1 通过集合来辅助查找
    public static Node findFirstCommonNodeBySet(Node head1, Node head2){
        // 遍历链表一，将链表所有节点放到集合
        Set<Node> set = new HashSet<>();
        while(head1 != null){
            set.add(head1);
            head1 = head1.next;
        }

        // 遍历链表二，查找是否有相同元素
        while(head2!=null){
            if (set.contains(head2)){
                return head2;
            }
            head2 = head2.next;
        }

        return null;
    }


    // 方法2 哈希
    public static Node findFirstCommonNodeByMap(Node head1, Node head2){
        // 将链表一的所有节点放到哈希
        Map<Node,Integer> map = new HashMap<>();
        while(head1 != null){
            map.put(head1,head1.val);
            head1 = head1.next;
        }

        // 遍历链表二，并查找哈希是否有链表二的节点
        while (head2!= null){
            if(map.containsKey(head2)){
                return head2;
            }
            head2 = head2.next;
        }

        return  null;
    }


    // 方法3 栈
    public static Node findFirstCommonNodeByStack(Node head1, Node head2) {
       // 将链表一和链表全都压入栈中
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        while(head1 != null){
            stack1.push(head1);
            head1 = head1.next;
        }

        while(head2 != null){
            stack2.push(head2);
            head2 = head2.next;
        }

        // 通过查找最后一个出栈的相同元素，即为第一个公共节点

        Node firstCommon = null;
        while(stack1.size() > 0 && stack2.size() > 0){
            if(stack1.peek() == stack2.peek()){
                firstCommon = stack1.pop();
                stack2.pop();
            }else {
                break;
            }
        }
        return firstCommon;
    }



    // 方法4 双指针


    /**
     * 简单构造两个链表
     *
     * @return
     */
    private static Node[] initLinkedList() {
        Node[] heads = new Node[2];
//        构造第一个链表交点之前的元素 1 ->2-> 3
        heads[0] = new Node(1);
        Node current1 = heads[0];
        current1.next = new Node(2);
        current1 = current1.next;
        current1.next = new Node(3);
        current1 = current1.next;
//        11->22
//        构造第二个链表交点之前的元素
        heads[1] = new Node(11);
        Node current2 = heads[1];
        current2.next = new Node(22);
        current2 = current2.next;
//        构造公共交点以及之后的元素

        Node node4 = new Node(4);
        current1.next = node4;
        current2.next = node4;
        Node node5 = new Node(5);
        node4.next = node5;


        Node node6 = new Node(6);
        node5.next = node6;

        return heads;
    }

}


