package com.example.tongguancun.chapter1_linklist.Commom;

/**
 * @author xieyunpeng
 * @create 2023/12/3
 */
public class Node {
    public int val;
    public Node next;

    public Node(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

}