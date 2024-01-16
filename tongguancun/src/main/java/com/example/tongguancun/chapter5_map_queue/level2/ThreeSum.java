package com.example.tongguancun.chapter5_map_queue.level2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author xieyunpeng
 * @Date 2024/1/15 20:49
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[]nums = {-1,0,1,2,-1,-4};
//        int[] nums = {0, 0, 0,0,0};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
    }


    //排序+双指针
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]){
                continue;
            }
            int third = n - 1;
            int target = -nums[first];

            for (int second = first + 1; second < n; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]){
                    continue;
                }
                while(second < third && nums[second] + nums[third] > target){
                    --third;
                }
                if (second == third){
                    break;
                }

                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
                }

            }

        }
        return res;
    }

}
