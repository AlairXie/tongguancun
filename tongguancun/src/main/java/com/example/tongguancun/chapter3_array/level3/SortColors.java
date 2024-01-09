package com.example.tongguancun.chapter3_array.level3;

import java.util.Arrays;

/**
 * @Author xieyunpeng
 * @Date 2024/1/9 21:05
 */
public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while(index <= right ){
            if(nums[index] == 0 ){
                int temp =  nums[left];
                nums[left] = nums[index];
                nums[index] = temp;
                left++;
                index++;
            }else if (nums[index] == 2){
                int temp =  nums[right];
                nums[right] = nums[index];
                nums[index] = temp;
                right--;
            }else {
                index++;
            }

        }
    }
}
