package com.example.tongguancun.chapter3_array.level2.topic2_1删除元素;

import java.util.Arrays;
import java.util.UUID;

/**
 * @Author xieyunpeng
 * @Date 2023/12/20 11:20
 */
public class DeleteVal {
    public static void main(String[] args) {

    }



    public static int deleteVal(int[] arr ,int val){
        int fast = 0;
        int slow = 0;
        while(fast < arr.length){
         if (arr[fast] != val){
                arr[slow] = arr[fast];
                slow++;
            }
            fast++;
        }
        System.out.println(Arrays.toString(arr));
        return slow;
    }



}
