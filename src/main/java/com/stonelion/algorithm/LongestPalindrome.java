package com.stonelion.algorithm;

/**
 * 最长回文子字符串
 * https://github.com/shixin198642/The-Art-Of-Programming-By-July/blob/master/ebook/zh/01.05.md
 *
 * Created by shixin on 9/3/16.
 */
public class LongestPalindrome {
    private static void longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            System.out.println(0);
        }

        int max = 1;
        int j;
        for (int i = 0; i < s.length(); i++) {
            // 如果回文是奇数个
            for (j = 0; i - j >= 0 && i + j < s.length(); j++) {
                if (s.charAt(i - j) != s.charAt(i + j)) {
                    break;
                }
            }
            if ((j * 2 - 1) > max) {
                max = j * 2 - 1;
            }

            // 如果回文是偶数个
            for (j = 0; i - j >= 0 && i + j + 1 < s.length(); j++) {
                if (s.charAt(i - j) != s.charAt(i + j + 1)) {
                    break;
                }
            }
            if (j * 2 > max) {
                max = j * 2;
            }
        }
        System.out.println(String.format("The longest palindrome is %d", max));
    }

    public static void main(String[] args) {
        String s = "abcdcba";
        longestPalindrome(s);
    }
}
