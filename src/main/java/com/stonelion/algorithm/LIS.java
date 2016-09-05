package com.stonelion.algorithm;

import java.util.Arrays;

/**
 * 求最长递增子序列.
 *
 * Created by shixin on 8/31/16.
 */
public class LIS {
    public static void LIS(int[] array) {
        int[] temp = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            temp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (array[j] < array[i] && temp[j] + 1 > temp[i]) {
                    temp[i] = temp[j] + 1;
                }
            }
        }

        System.out.println(Arrays.toString(temp));

        int max = 0;
        for (int i : temp) {
            if (i > max) {
                max = i;
            }
        }
        System.out.println(String.format("最长递增子串长度是:%d", max));
    }

    public static void main(String[] args) {
        int array[] = {1, 9, 3, 8, 11, 4, 5, 6, 4, 1, 9, 7, 1, 7};
        LIS(array);
    }
}
