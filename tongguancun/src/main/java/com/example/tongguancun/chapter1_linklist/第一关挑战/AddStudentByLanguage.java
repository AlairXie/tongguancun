package com.example.tongguancun.chapter1_linklist.第一关挑战;


import com.example.tongguancun.Commom.Node;

/**
 * 帮鱼皮打印算法学员名单
 * @author 月月鸟
 */
public class AddStudentByLanguage {
    public static void main(String[] args) {

        StudentNode studentNode = initLinkedList();

        addStudentByLanguage(studentNode,new StudentNode("ac","java"));
        addStudentByLanguage(studentNode,new StudentNode("cc","python"));
        StudentNode afterAddStudent = addStudentByLanguage(studentNode,new StudentNode("bc","cpp"));

        System.out.println(toString(afterAddStudent));
    }


    public static StudentNode addStudentByLanguage(StudentNode head , StudentNode newNode){
        if (head == null || newNode == null){
            return head;
        }
        StudentNode cur = head;
        while(cur != null){
            // 遍历到最后一个元素还没有退出循环体，则说明是新语言或者最后一种语言，直接放末尾
            if (cur.next == null ){
                cur.next = newNode;
                break;
            }
            if (cur.language.equals(newNode.language) && !cur.language.equals(cur.next.language) ){ // 是否同组，同组放末尾
                newNode.next = cur.next;
                cur.next = newNode;
                break;
            }
            cur = cur.next;
        }

        return head;
    }




    static class StudentNode{
        public String name;
        public String language;
        public StudentNode next;

        public StudentNode(){

        }

        public StudentNode(String name,String language){
            this.name = name;
            this.language = language;
            this.next = null;
        }
    }


    public static StudentNode initLinkedList() {
        StudentNode student1 = new StudentNode("aa","java");
        StudentNode student2 = new StudentNode("ab","java");
        StudentNode student3 = new StudentNode("ba","cpp");
        StudentNode student4 = new StudentNode("bb","cpp");
        StudentNode student5 = new StudentNode("ca","python");
        StudentNode student6 = new StudentNode("cb","python");
        StudentNode[] list = {student1,student2,student3,student4,student5,student6};
        StudentNode head = null, cur = null;
        for (int i = 0; i < list.length; i++) {
            StudentNode newNode = list[i];
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


    public static String toString(StudentNode head) {
        StudentNode current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.name).append("-").append(current.language).append("\t");
            current = current.next;
        }
        return sb.toString();
    }
}
