package com.stonelion.algorithm;

/**
 * 求最长公共子串, 动态规划(Longest Common Subsequence)
 *
 * Created by shixin on 8/22/16.
 */
public class LCSLength {
    private static void getLCS(char[] array1, char[] array2, int[][] c, int[][] b) {
        for (int i = 1; i <= array1.length; i++) {
            for (int j = 1; j <= array2.length; j++) {
                if (array1[i - 1] == array2[j - 1]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = 1;
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = 2;
                } else if (c[i - 1][j] < c[i][j - 1]) {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = 3;
                }
            }
        }
    }

    private static void getLCSString(int i, int j, char[] array1, char[] array2, int[][] b, StringBuilder stringBuilder) {
        if (i == 0 || j == 0) {
            return;
        }

        if (b[i][j] == 1) {
            getLCSString(i - 1, j - 1, array1, array2, b, stringBuilder);
            stringBuilder.append(array1[i - 1]);
        } else if (b[i][j] == 2) {
            getLCSString(i - 1, j, array1, array2, b, stringBuilder);
        } else {
            getLCSString(i, j - 1, array1, array2, b, stringBuilder);
        }
    }

    private static String getLCS(char[] array1, char[] array2) {
        // 记录最长公共子串长度
        int[][] c = new int[array1.length + 1][array2.length + 1];
        // 记录每一步采用的动作
        int[][] b = new int[array1.length + 1][array2.length + 1];
        getLCS(array1, array2, c, b);

        // 查看分析过程
        System.out.println("c:");
        for (int[] rows : c) {
            for (int column : rows) {
                System.out.print(String.format("%5d", column));
            }
            System.out.println();
        }
        System.out.println("b:");
        for (int[] rows : b) {
            for (int column : rows) {
                System.out.print(String.format("%5d", column));
            }
            System.out.println();
        }

        // 根据动作, 构建最长公共子串
        StringBuilder stringBuilder = new StringBuilder();
        getLCSString(array1.length, array2.length, array1, array2, b, stringBuilder);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        char[] array1 = new char[] {'a', 'c', 'd', 'f', 'g', 'h'};
        char[] array2 = new char[] {'b', 'a', 'c', 'f', 'q', 'h'};
        System.out.println(getLCS(array1, array2));
    }
}
