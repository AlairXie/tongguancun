package com.example.tongguancun.chapter3_array.level3;

import org.springframework.data.relational.core.sql.In;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author xieyunpeng
 * @Date 2024/1/9 20:14
 */
public class MoreThanHalfNum {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] arr = {1, 4, 4, 4,4, 2, 5, 4, 2};
//        int[] arr = {1, 2, 3, 4};
        System.out.println(moreThanHalfNum(arr));
        System.out.println(majorityElement(arr));
    }

    public static int moreThanHalfNum(int[] arr){
        if (arr==null){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        int halfNum = 0;
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            if (map.get(arr[i]) > arr.length / 2 ){
                halfNum = arr[i];
            }
        }
        return halfNum;
    }

    /**
     * 特殊计数法
     */
    public static int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0){
                candidate = num;
            }
            count += (num == candidate) ? 1 : - 1;

        }
        return candidate;
    }

}
