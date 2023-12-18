package com.example.tongguancun.chapter3_array.level1;

import com.example.tongguancun.Commom.InitArray;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author xieyunpeng
 * @Date 2023/12/18 22:17
 */
public class BasicAddByElement {

    public static void main(String[] args) {
        int[] arr = InitArray.initOrderArray();
        System.out.print("添加数据前: ");
        System.out.println(Arrays.toString(arr));
         baseAddOneElement(arr, 5, 6);
        System.out.print("添加数据后: ");
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 添加一个元素
     * 前提：数组是有序数组,数组递增
     * size 是记录数组中的个数
     *
     * @return
     */
    public static int baseAddOneElement(int[] arr, int size, int element) {
        // 判断是添加的位置是否越界
        if (size >= arr.length) {
            return -1;
        }


        // 寻找插入的位置
        int index = size;
        for (int i = 0; i < size; i++) {
            if (arr[i] > element) {
                index = i;
                break;
            }
        }

        // 将数据后移并且插入数据
        for (int j = size ; j > index; j--) {
            arr[j] = arr[j - 1];
        }
        arr[index] = element;
        return index;
    }
}
