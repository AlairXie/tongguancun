package com.example.tongguancun.chapter3_array.level1;

import com.example.tongguancun.Commom.InitArray;

import java.util.Arrays;

/**
 * @Author xieyunpeng
 * @Date 2023/12/18 22:38
 */
public class BasicDeleteByElement {
    public static void main(String[] args) {
        int[] arr = InitArray.initOrderArray();
        int size = basicDelete(arr,5,4);
        InitArray.printList("根据索引删除", arr,size);
    }

    /**
     * 从数组中删除key元素
     * @return
     */
    public static int basicDelete(int[] arr,int size , int key){
        // 查找是否有key元素
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (key == arr[i]){
                index = i;
                break;
            }
        }

        // 后续数组往前挪动，实现删除
        if (index != -1){
            for (int j = index + 1; j < size; j++) {
                arr[j - 1] = arr[j];
            }
            size--;
        }

        return size;
    }
}
