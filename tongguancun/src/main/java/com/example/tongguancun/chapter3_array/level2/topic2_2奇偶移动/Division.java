package com.example.tongguancun.chapter3_array.level2.topic2_2奇偶移动;

import java.util.Arrays;

/**
 * @Author xieyunpeng
 * @Date 2024/1/8 18:56
 */
public class Division {

    public static void main(String[] args) {
        int[] arr = {0,1,2};
        int test = 1;
        if (test == 1) {
            //双指针,不稳定的方法
            System.out.println(Arrays.toString(sortArrayByParity(arr)));
        } else {
            //模仿冒泡排序，稳定的方法
//            System.out.println(Arrays.toString(reOrderArray(arr)));
        }
    }

    public static int[] sortArrayByParity(int[] arr){
        int left  = 0;
        int right = arr.length - 1;

        while(left < right){
            if (arr[left] % 2 > arr[right] % 2 ){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
            if (arr[left]%2==0)left++;
            if (arr[right]%2==1)right--;
        }
        return arr;
    }
}
