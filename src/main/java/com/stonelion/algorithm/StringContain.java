package com.stonelion.algorithm;

import java.util.Arrays;

/**
 * 给定两个分别由字母组成的字符串A和字符串B，字符串B的长度比字符串A短。
 * 请问，如何最快地判断字符串B中所有字母是否都在字符串A里？
 * https://github.com/shixin198642/The-Art-Of-Programming-By-July/blob/master/ebook/zh/01.02.md
 *
 * Created by shixin on 9/3/16.
 */
public class StringContain {
    /**
     * 循环遍历两个字符串, 挨个比较, 时间复杂度是O(m*n)
     *
     * @param s1
     * @param s2
     * @return
     */
    private static boolean contains1(String s1, String s2) {
        for (int i = 0; i < s2.length(); i++) {

            int j = 0;
            while (j < s1.length() && s1.charAt(j) != s2.charAt(i)) {
                j++;
            }

            if (j >= s1.length()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 先排序, 在比较, 按照有序的前提进行比较, 时间复杂度是O(m*logm) + O(n*logn) + O(m+n)
     *
     * @param s1
     * @param s2
     * @return
     */
    private static boolean contains2(String s1, String s2) {
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();

        Arrays.sort(array1);
        Arrays.sort(array2);

        int j = 0; // array1的下标
        for (int i = 0; i < array2.length; i++) {
            while (j < array1.length && array1[j] < array2[i]) {
                j++;
            }
            if (j >= array1.length || array1[j] > array2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 使用hashtable的方法, 时间复杂度是O(m+n)
     *
     * @param s1
     * @param s2
     * @return
     */
    private static boolean contains3(String s1, String s2) {
        int hash = 0;
        for (char c : s1.toCharArray()) {
            hash |= (1 << (c - 'A'));
        }
        for (char c : s2.toCharArray()) {
            if ((hash & (1 << (c - 'A'))) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "DCB";

        System.out.println(contains1(s1, s2));
        System.out.println(contains2(s1, s2));
        System.out.println(contains3(s1, s2));
    }
}
