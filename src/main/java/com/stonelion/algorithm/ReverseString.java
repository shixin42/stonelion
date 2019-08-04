package com.stonelion.algorithm;

/**
 * 字符串反转, I am boy 反转成 boy am I.
 * Created by shixin on 10/16/16.
 */
public class ReverseString {
    private static void reverse(char[] array, int start, int end) {
        while (start < end) {
            char temp = array[start];
            array[start++] = array[end];
            array[end--] = temp;
        }
    }

    private static String reverseString(String s) {
        char[] array = s.toCharArray();
        // 先全反转
        reverse(array, 0, array.length - 1);

        int start = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != ' ' && (i == 0 || array[i - 1] == ' ')) {
                start = i;
            } else if (array[i] == ' ') {
                // 再反转一个单词
                reverse(array, start, i - 1);
            }
        }

        return new String(array);
    }

    public static void main(String[] args) {
        String s = "I love java!";
        System.out.println(reverseString(s));
    }
}
