package com.stonelion.algorithm;

import java.util.Arrays;

/**
 * 求最大连续子序列, 即连续最大子序列和最大.
 * https://github.com/shixin198642/The-Art-Of-Programming-By-July/blob/master/ebook/zh/02.04.md
 *
 * Created by shixin on 9/1/16.
 */
public class MaxSubSum {
    /**
     * 穷举法, 时间复杂度O(n^3)
     *
     * @param array
     */
    private static void maxSubSum1(int[] array) {
        int maxSum = 0;
        int startIndex = 0;
        int endIndex = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                // 计算每个子序列和
                int currentSum = 0;
                for (int k = i; k <= j; k++) {
                    currentSum += array[k];
                }

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    startIndex = i;
                    endIndex = j;
                }
            }
        }

        System.out.println(String.format("最大连续自序列和是:%d, 最大连续子序列是:%s", maxSum, Arrays.toString(Arrays.copyOfRange(array, startIndex, endIndex + 1))));
    }

    /**
     * 第一种穷举法的改进, 时间复杂度O(n^2)
     *
     * @param array
     */
    private static void maxSubSum2(int[] array) {
        int maxSum = 0;
        int startIndex = 0;
        int endIndex = 0;

        for (int i = 0; i < array.length; i++) {
            int currentSum = 0;
            for (int j = i; j < array.length; j++) {
                currentSum += array[j];

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    startIndex = i;
                    endIndex = j;
                }
            }
        }

        System.out.println(String.format("最大连续自序列和是:%d, 最大连续子序列是:%s", maxSum, Arrays.toString(Arrays.copyOfRange(array, startIndex, endIndex + 1))));
    }

    /**
     * 线性复杂度的算法, O(N)
     *
     * @param array
     */
    private static void maxSubSum3(int[] array) {
        int startIndex = 0;
        int endIndex = 0;
        int currentStartIndex = 0;

        int maxSum = 0;
        int currentSum = 0;

        for (int i = 0; i < array.length; i++) {
            if (currentSum + array[i] >= array[i]) { // 如果当前元素加入到前面的序列中不小于当前元素, 说明是个递增的序列
                currentSum = currentSum + array[i];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    startIndex = currentStartIndex;
                    endIndex = i;
                }
            } else {
                // 否则以当前元素为第一个元素, 重新开始
                currentSum = array[i];
                currentStartIndex = i;
            }
        }
        System.out.println(String.format("最大连续自序列和是:%d, 最大连续子序列是:%s", maxSum, Arrays.toString(Arrays.copyOfRange(array, startIndex, endIndex + 1))));
    }

    public static void main(String[] args) {
        int[] array = new int[] {-2, 11, -4, 13, -5, 2};
        maxSubSum1(array);
        maxSubSum2(array);
        maxSubSum3(array);
    }
}
