package com.stonelion.algorithm;

import java.util.Arrays;

/**
 * 最长公共子串, 动态规划
 *
 * Created by shixin on 9/1/16.
 */
public class LCString {
    public static void main(String[] args) {
        //String str1 = new String("123456abcd567");
        //String str2 = new String("234dddabc45678");
        //String str1 = new String("aab12345678cde");
        //String str2 = new String("ab1234yb1234567");
        String str1 = new String("bab");
        String str2 = new String("caba");
        getLCString(str1.toCharArray(), str2.toCharArray());
    }

    private static void getLCString(char[] array1, char[] array2) {

        int[] maxLength = new int[Math.max(array1.length, array2.length)];
        int[] maxIndex = new int[Math.max(array1.length, array2.length)];
        int[] c = new int[array2.length];

        for (int i = 0; i < array1.length; i++) {
            for (int j = array2.length - 1; j >= 0; j--) {
                if (array1[i] == array2[j]) {
                    if (i == 0 || j == 0) {
                        c[j] = 1;
                    } else {
                        c[j] = c[j - 1] + 1;
                    }
                } else {
                    c[j] = 0;
                }

                if (c[j] > maxLength[0]) {
                    maxLength[0] = c[j];
                    maxIndex[0] = j;

                    for (int k = 1; k < Math.max(array1.length, array2.length); k++) {
                        maxLength[k] = 0;
                        maxIndex[k] = 0;
                    }
                } else if (c[j] == maxLength[0]) {
                    for (int k = 1; k < Math.max(array1.length, array2.length); k++) {
                        if (maxLength[k] == 0) {
                            maxLength[k] = c[j];
                            maxIndex[k] = j;
                            break; // 在后面加一个就要退出循环了
                        }
                    }
                }
            }
            System.out.println(Arrays.toString(c));
        }

        for (int j = 0; j < maxLength.length; j++) {
            if (maxLength[j] > 0) {
                System.out.println("第" + (j + 1) + "个公共子串:");
                for (int i = maxIndex[j] - maxLength[j] + 1; i <= maxIndex[j]; i++) {
                    System.out.print(array2[i]);
                }
                System.out.println(" ");
            }
        }
    }
}
