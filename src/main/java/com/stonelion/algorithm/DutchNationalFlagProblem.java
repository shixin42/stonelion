package com.stonelion.algorithm;

import java.util.Arrays;

/**
 * 荷兰国旗问题, 这里衍生出三色球问题:
 * 现有n个红白蓝三种不同颜色的小球，乱序排列在一起，请通过两两交换任意两个球，使得从左至右，依次是一些红球、一些白球、一些蓝球。
 * Created by shixin on 9/4/16.
 */
public class DutchNationalFlagProblem {
    /**
     * 要求只遍历一遍数组,就能排好序
     *
     * @param array
     */
    private static void sort(int[] array) {
        if (array == null) {
            return;
        }

        int startIndex = 0;
        int currentIndex = 0;
        int endIndex = array.length - 1;

        while (currentIndex < endIndex) {
            if (array[currentIndex] == 0) {
                swap(array, startIndex, currentIndex);
                startIndex++;
                currentIndex++;
            } else if (array[currentIndex] == 1) {
                currentIndex++;
            } else if (array[currentIndex] == 2) {
                swap(array, endIndex, currentIndex);
                endIndex--;
            }
        }
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        // 这里用0,1,2表示三个颜色的球
        int[] array = new int[] {0, 0, 1, 1, 1, 2, 0, 2, 1, 2, 0, 1, 2};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
