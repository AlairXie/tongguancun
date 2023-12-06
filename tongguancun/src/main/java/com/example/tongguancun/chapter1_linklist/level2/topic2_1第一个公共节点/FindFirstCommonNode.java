package com.example.tongguancun.chapter1_linklist.level2.topic2_1第一个公共节点;

import com.example.tongguancun.Commom.InitList;
import com.example.tongguancun.Commom.Node;

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
        Node[] heads = InitList.initLinkedList();
        //la 为 1 2 3 4 5
        //lb 为 11 22 4 5
        Node la = heads[0];
        Node lb = heads[1];



        int testMethod = 4;
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
            case 4://方法4：通过拼接辅助查找
                node = findFirstCommonNodeByCombine(la, lb);
                break;
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



    // 方法4 拼接双指针
    public static Node findFirstCommonNodeByCombine(Node head1,Node head2){
        if (head1 == null || head2 == null){
            return null;
        }
        Node p1 = head1;
        Node p2 =head2;
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
            if(p1!=p2){
                if(p1==null){
                    p1 = head2;
                }
                if (p2==null){
                    p2 = head1;
                }
            }
        }
        return p1;
    }




}


