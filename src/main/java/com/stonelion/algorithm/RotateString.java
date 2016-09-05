package com.stonelion.algorithm;

/**
 * 给定一个字符串，要求把字符串前面的若干个字符移动到字符串的尾部，如把字符串“abcdef”前面的2个字符'a'和'b'移动到字符串的尾部，使得原字符串变成字符串“cdefab”。
 * 请写一个函数完成此功能，要求对长度为n的字符串操作的时间复杂度为 O(n)，空间复杂度为 O(1)。
 *
 * https://github.com/shixin198642/The-Art-Of-Programming-By-July/blob/master/ebook/zh/01.01.md
 * Created by shixin on 9/3/16.
 */
public class RotateString {
    private static void reverse(char[] array, int start, int end) {
        while (start < end) {
            char temp = array[start];
            array[start++] = array[end];
            array[end--] = temp;
        }
    }

    private static String rotateString(String str, int n) {
        char[] array = str.toCharArray();
        reverse(array, 0, n - 1);
        reverse(array, n, array.length - 1);
        reverse(array, 0, array.length - 1);
        return new String(array);
    }

    public static void main(String[] args) {
        String s = "abcdef";
        System.out.println(rotateString(s, 2));
    }
}
