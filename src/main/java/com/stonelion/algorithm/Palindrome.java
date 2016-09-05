package com.stonelion.algorithm;

/**
 * 判断是不是回文
 * https://github.com/shixin198642/The-Art-Of-Programming-By-July/blob/master/ebook/zh/01.04.md
 *
 * Created by shixin on 9/3/16.
 */
public class Palindrome {
    /**
     * 头尾两指针向中间移动.
     *
     * @param s
     * @return
     */
    private static boolean isPalindrome1(String s) {
        if (s == null || s.length() < 1) {
            return false;
        }

        for (int start = 0, end = s.length() - 1; start < end; start++, end--) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 从中间定义指针, 向两边移动
     *
     * @param s
     * @return
     */
    private static boolean isPalindrome2(String s) {
        if (s == null || s.length() < 1) {
            return false;
        }

        boolean odd = (s.length() & 1) == 0 ? false : true;
        int left = odd ? s.length() / 2 : s.length() / 2 - 1;
        int right = odd ? s.length() / 2 : s.length() / 2;
        for (; left >= 0; left--, right++) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "abcdecba";
        System.out.println(isPalindrome1(s));
        System.out.println(isPalindrome2(s));
    }
}
