package com.example.tongguancun.chapter3_array.level3;

import org.springframework.data.relational.core.sql.In;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author xieyunpeng
 * @Date 2024/1/9 20:46
 */
public class FindOneNum {
    public static void main(String[] args) {
//        int[] arr = {4, 1, 2, 1, 2};
        int[] arr = {4, 1};
//        System.out.println(findOneNum(arr));
        System.out.println(findOneNum2(arr));
    }

    public static Integer findOneNum(int[] arr){
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (!set.add(i)){
                set.remove(i);
            }
        }
        if (set.size()==0){
            return null;
        }
        return set.toArray(new Integer[set.size()])[0];

    }


    public static int findOneNum2(int[] arr){
        int flag = 0;
        for (int i : arr) {
          flag ^= i;
        }
       return flag;

    }
}
