package com.example.tongguancun.chapter3_array.level2.topic2_1删除元素;

/**
 * 删除有序数组的重复元素
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2,3,3,4,4,5 };
        int last = deleteDuplicates(arr);
        for (int i = 0; i < last; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

    public static int deleteDuplicates(int[] arr) {
        // slow表示可以放入新元素的位置，索引为0的元素不用管
        int slow = 1;
        int fast = 0;
        while (fast < arr.length) {
            if (arr[fast] != arr[slow - 1]) {
                arr[slow] = arr[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }

}
