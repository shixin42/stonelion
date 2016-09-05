package com.stonelion.algorithm;

/**
 * 0-1背包问题, 使用动态规划算法.
 *
 * Created by shixin on 8/31/16.
 */
public class Knapsack {
    public static void main(String[] args) {
        int knapsackWeight = 10; // 背包的总重量
        int values[] = {10, 40, 30, 50}; // 每个物品的价值
        int weights[] = {5, 4, 6, 3}; // 每个物品的重量

        System.out.println(knapsack(values, weights, knapsackWeight));
    }

    public static int knapsack(int[] values, int[] weights, int knapsackWeight) {
        int totalNumber = values.length;

        // 动态规划表, 存储了对应m个物品, n的重量下最大的价值.
        int[][] referTable = new int[totalNumber + 1][knapsackWeight + 1];
        for (int i = 0; i <= knapsackWeight; i++) {
            referTable[0][i] = 0;
        }
        for (int i = 0; i <= totalNumber; i++) {
            referTable[i][0] = 0;
        }

        for (int item = 1; item <= totalNumber; item++) {
            for (int weight = 1; weight <= knapsackWeight; weight++) {
                if (weights[item - 1] <= weight) {
                    referTable[item][weight] = Math.max(
                            referTable[item - 1][weight],
                            values[item - 1] + referTable[item - 1][weight - weights[item - 1]]
                    );
                } else {
                    referTable[item][weight] = referTable[item - 1][weight];
                }
            }
        }

        // 打印
        for (int[] rows : referTable) {
            for (int column : rows) {
                System.out.print(String.format("%5d", column));
            }
            System.out.println();
        }

        // 返回背包能容纳的最大价值
        return referTable[totalNumber][knapsackWeight];
    }
}
