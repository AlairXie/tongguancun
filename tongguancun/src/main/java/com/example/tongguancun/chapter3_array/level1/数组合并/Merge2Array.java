package com.example.tongguancun.chapter3_array.level1.数组合并;

import com.example.tongguancun.Commom.InitArray;

/**
 * @Author xieyunpeng
 * @Date 2023/12/20 10:30
 */
public class Merge2Array {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,0,0,0,};
        int[] arr2 = new int[]{2, 5, 6};

        int testMethod = 1;
        switch (testMethod) {
            case 1://通过排序实现合并
                merge2Array(arr1, 3, arr2, 3);
                break;
        }

        InitArray.printList("合并的结果为", arr1, 6);
    }


    public static int[] merge2Array(int[] nums1, int n1, int[] nums2, int n2) {
        int i = n1 + n2 - 1;
        int len1 = n1 - 1;
        int len2 = n2 - 1;
        while(len1>=0 && len2 >=0){
            if (nums1[len1] > nums2[len2]){
                nums1[i--] = nums1[len1--];
            }else {
                nums1[i--] = nums2[len2--];
            }
        }
        while(len1>0) nums1[i--] = nums1[len1--];
        while(len2>0) nums1[i--] = nums2[len2--];

        return nums1;
    }
}
