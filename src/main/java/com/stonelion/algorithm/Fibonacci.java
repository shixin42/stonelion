package com.stonelion.algorithm;

/**
 * 一个台阶总共有n 级，如果一次可以跳1 级，也可以跳2 级。求总共有多少总跳法，并分析算法的时间复杂度。
 * https://github.com/shixin198642/The-Art-Of-Programming-By-July/blob/master/ebook/zh/02.05.md
 * Created by shixin on 9/4/16.
 */
public class Fibonacci {
    /**
     * 第一种利用递归.
     *
     * @param n
     * @return
     */
    private static int fibonacci(int n) {
        // 当只有一阶台阶时
        if (n == 1) {
            return 1;
        }

        // 当有两阶台阶时
        if (n == 2) {
            return 2;
        }

        // 当有多个台阶时, 最后一次要么跳一个, 要么跳两个
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * 第二种利用推导的办法.
     *
     * @param n
     * @return
     */
    private static int climbStairs(int n) {
        if (n < 2) {
            return 1;
        }

        int[] array = new int[] {1, 1, 0};
        for (int i = 2; i <= n; i++) {
            array[2] = array[0] + array[1];
            array[0] = array[1];
            array[1] = array[2];
        }
        return array[2];
    }

    public static void main(String[] args) {
        int n = 20;//台阶数
        System.out.println(String.format("当有%d台阶时, 有%d种跳法", n, fibonacci(10)));
        System.out.println(String.format("当有%d台阶时, 有%d种跳法", n, climbStairs(10)));
    }
}
