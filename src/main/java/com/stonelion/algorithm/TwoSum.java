package com.stonelion.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 输入一个数组和一个数字，在数组中查找两个数，使得它们的和正好是输入的那个数字。
 * 要求时间复杂度是O(N)。如果有多对数字的和等于输入的数字，输出任意一对即可。
 * 例如输入数组1、2、4、7、11、15和数字15。由于4+11=15，因此输出4和11。
 * https://github.com/shixin198642/The-Art-Of-Programming-By-July/blob/master/ebook/zh/02.02.md
 *
 * Created by shixin on 9/4/16.
 */
public class TwoSum {
    /**
     * 构造一个hash表, 空间换时间.
     *
     * @param array
     * @param sum
     */
    private static void twoSum1(int[] array, int sum) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            if (set.contains(sum - array[i])) {
                System.out.println(String.format("找到:%d, %d", array[i], sum - array[i]));
            }
            return;

        }
        System.out.println("没有找到对应的两个数");
    }

    /**
     * 时间换空间, 如果是个无序数组, 先快速排序, 时间复杂度是O(NlogN)
     *
     * @param array
     * @param sum
     */
    private static void twoSum2(int[] array, int sum) {
        // 如果是无序的,先排序
        Arrays.sort(array);

        for (int i = 0, j = array.length - 1; i < j; ) {
            if (array[i] + array[j] == sum) {
                System.out.println(String.format("找到:%d, %d", array[i], array[j]));
                return;
            } else if (array[i] + array[j] > sum) {
                j--;
            } else {
                i++;
            }
        }

        System.out.println("没有找到对应的两个数");
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 4, 7, 11, 15};
        twoSum1(array, 12);
        twoSum2(array, 12);
    }
}
