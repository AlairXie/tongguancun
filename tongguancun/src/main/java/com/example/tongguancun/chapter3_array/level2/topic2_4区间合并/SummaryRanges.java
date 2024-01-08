package com.example.tongguancun.chapter3_array.level2.topic2_4区间合并;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xieyunpeng
 * @Date 2024/1/8 19:34
 */
public class SummaryRanges {
    public static void main(String[] args) {
        int[] arr = {0, 2, 3, 4, 6, 8, 9};
        System.out.println(summaryRanges(arr));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> resultList = new ArrayList<>();
        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            if (fast + 1 == nums.length || nums[fast] + 1 != nums[fast + 1]) {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[slow]);
                if (slow != fast) {
                    sb.append("->").append(nums[fast]);
                }
                resultList.add(sb.toString());
                slow = fast + 1;
            }
        }
        return resultList;
    }

}
