package com.stonelion.algorithm;

/**
 * Created by shixin on 8/19/16.
 */
public class Search {
    /**
     * 递归实现二分查找
     *
     * @param array
     * @param key
     * @return
     */
    public static int binarySearchRecursion(int[] array, int key) {
        if (array == null || array.length == 0) {
            return -1;
        }
        return binarySearch(array, 0, array.length - 1, key);
    }

    public static int binarySearch(int[] array, int start, int end, int key) {
        int mid = (start + end) / 2;
        if (array[mid] == key) {
            return mid;
        }

        if (start >= end) {
            return -1;
        } else if (key < array[mid]) {
            return binarySearch(array, start, mid - 1, key);
        } else if (key > array[mid]) {
            return binarySearch(array, mid + 1, end, key);
        }
        return -1;
    }

    public static void main(String[] args) {
        int srcArray[] = {3, 5, 11, 17, 21, 23, 28, 30, 32, 50, 64, 78, 81, 95, 101};
        System.out.println(binarySearchRecursion(srcArray, 81));
    }
}
