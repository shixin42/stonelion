package com.stonelion.algorithm;

/**
 * Created by shixin on 9/3/16.
 */
public class AllSort {
    /**
     * 递归实现字符串数组的全排列, 时间复杂度O(n!)
     *
     * @param array
     * @param start
     * @param end
     */
    private static void permutation(char[] array, int start, int end) {
        if (start == end) {
            // 当只要求对数组中一个字母进行全排列时，只要就按该数组输出即可
            System.out.println(new String(array));
        } else {
            for (int i = start; i <= end; i++) {
                // 交换数组第一个元素与后续的元素
                char temp = array[start];
                array[start] = array[i];
                array[i] = temp;

                // 后续元素递归全排列
                permutation(array, start + 1, end);

                // 将交换后的数组还原
                temp = array[start];
                array[start] = array[i];
                array[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        char[] array = new char[] {'a', 'b', 'c', 'd'};
        permutation(array, 0, array.length - 1);
    }
}
