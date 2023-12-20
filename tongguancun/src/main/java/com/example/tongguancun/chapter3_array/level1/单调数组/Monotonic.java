package com.example.tongguancun.chapter3_array.level1.单调数组;

import com.example.tongguancun.Commom.InitArray;

/**
 * @Author xieyunpeng
 * @Date 2023/12/19 12:07
 *
 * 数组单调性
 * 思想太牛
 */
public class Monotonic {
    public static void main(String[] args) {
        int[] arr = InitArray.initOrderArray();
        int[] unOrderArray = InitArray.initUnOrderArray();
        System.out.println(isMonotonic(arr));
        System.out.println(isMonotonic(unOrderArray));
    }


    // 这才是算法思想
    public static boolean isMonotonic(int[] arr){
        boolean asc = true, des = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i+1]){
                asc = false;
            }
            if (arr[i] < arr[i+1]){
                des = false;
            }
        }

        return asc || des;
    }


    // 自己想的，两次循环，并没有用到算法
    public static boolean isMonotonicBad(int[] arr){
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i-1] < arr[i] && arr[i] > arr[i+1]){
                return false;
            }
        }
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i-1] > arr[i] && arr[i] < arr[i+1]){
                return false;
            }
        }
        return true;

    }


}
