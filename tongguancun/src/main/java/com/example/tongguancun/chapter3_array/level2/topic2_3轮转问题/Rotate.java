package com.example.tongguancun.chapter3_array.level2.topic2_3轮转问题;

import java.util.Arrays;

/**
 * @Author xieyunpeng
 * @Date 2024/1/8 19:18
 */
public class Rotate {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,k - 1);
        reverse(nums,k,nums.length - 1);
    }

    public static void reverse(int nums[] , int left ,int right){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }


}
