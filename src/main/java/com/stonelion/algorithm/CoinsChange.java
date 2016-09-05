package com.stonelion.algorithm;

/**
 * 硬币找零, 动态规划.
 *
 * Created by shixin on 8/31/16.
 */
public class CoinsChange {
    /**
     * @param coinValue 硬币面值
     * @param minCoin 最小的硬币面值
     * @param totalMoney 需要找零的钱数
     */
    public static void makeChange(int[] coinValue, final int minCoin, int totalMoney) {
        // 保存每一个面值找零所需的最小硬币数，0号单元舍弃不用，所以要多加1
        int[] coinsUsed = new int[totalMoney + 1];
        coinsUsed[0] = 0;

        for (int money = 1; money <= totalMoney; money++) {
            int minCoinsUsed = money / minCoin;

            for (int j = 0; j < coinValue.length; j++) {
                if (money >= coinValue[j]) {
                    int temp = coinsUsed[money - coinValue[j]] + 1;
                    if (temp < minCoinsUsed) {
                        minCoinsUsed = temp;
                    }
                }
            }

            coinsUsed[money] = minCoinsUsed;
            System.out.println(String.format("money:%d, coinsUsed:%d", money, coinsUsed[money]));
        }
    }

    public static void main(String[] args) {
        // 需要找零的面值
        int money = 63;
        // 硬币面值预先已经按降序排列
        int[] coinValue = new int[] {25, 21, 10, 5, 1};

        makeChange(coinValue, 1, money);
    }
}
