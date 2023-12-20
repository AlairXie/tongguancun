package com.example.tongguancun.Commom;

/**
 * @Author xieyunpeng
 * @Date 2023/12/18 22:24
 */
public class InitArray {

    public static int[] initUnOrderArray() {
        int[] arr = new int[20];
        arr[0] = 3;
        arr[1] = 4;
        arr[2] = 9;
        arr[3] = 1;
        arr[4] = 10;
        arr[5] = 7;
        return arr;
    }


    public static int[] initOrderArray() {
        int[] arr = new int[5];
        arr[0] = 3;
        arr[1] = 4;
        arr[2] = 7;
        arr[3] = 8;
        arr[4] = 10;
        return arr;
    }


    public static void printList(String msg, int[] arr, int size) {
        System.out.println("\n通过" + msg + "打印");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }



}
