package com.stonelion.algorithm;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * 冒泡排序.
 * 选择排序.
 * 插入排序.
 * 快速排序.
 * 归并排序.
 * 洗牌排序.
 *
 * Created by shixin on 8/18/16.
 */
public class Sort {
    public static int[] bubbleSortAsc(int[] array) {
        System.out.println("冒泡asc:");

        if (array == null) {
            return array;
        }

        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }

        return array;
    }

    public static int[] bubbleSortDesc(int[] array) {
        System.out.println("冒泡desc:");

        if (array == null) {
            return array;
        }

        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }

        return array;
    }

    public static int[] selectSortAsc(int[] array) {
        System.out.println("选择排序asc:");

        if (array == null) {
            return array;
        }

        for (int i = array.length - 1; i > 0; i--) {
            int maxIndex = i;
            int maxValue = array[i];

            for (int j = 0; j < i; j++) {
                if (array[j] > maxValue) {
                    maxIndex = j;
                    maxValue = array[j];
                }
            }
            if (maxIndex != i) {
                swap(array, i, maxIndex);
            }
        }

        return array;
    }

    public static int[] selectSortDesc(int[] array) {
        System.out.println("选择排序desc:");

        if (array == null) {
            return array;
        }

        for (int i = array.length - 1; i > 0; i--) {
            int minIndex = i;
            int minValue = array[i];
            for (int j = 0; j < i; j++) {
                if (array[j] < minValue) {
                    minIndex = j;
                    minValue = array[j];
                }
            }
            if (minIndex != i) {
                swap(array, i, minIndex);
            }
        }

        return array;
    }

    public static int[] insertSortAsc(int[] array) {
        System.out.println("插入排序asc:");

        if (array == null) {
            return array;
        }

        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                int temp = array[i];

                int j = i - 1;
                while (j >= 0 && array[j] > temp) {
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = temp;
            }
        }
        return array;
    }

    public static int[] insertSortDesc(int[] array) {
        System.out.println("插入排序asc:");

        if (array == null) {
            return array;
        }

        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] < array[i]) {
                int temp = array[i];

                int j = i - 1;
                while (j >= 0 && array[j] < temp) {
                    array[j + 1] = array[j--];
                }
                array[j + 1] = temp;
            }
        }
        return array;
    }

    /**
     * 快速排序,升序排序,时间复杂度=O(nlogn)
     *
     * @param array
     * @return
     */
    public static int[] quickSortAsc(int[] array) {
        System.out.println("快速排序asc:");

        if (array == null) {
            return array;
        }

        quickSortAsc(array, 0, array.length - 1);
        return array;
    }

    public static void quickSortAsc(int[] array, int left, int right) {
        if (left > right) {
            return;
        }

        int key = array[left];
        int leftIndex = left;
        int rightIndex = right;
        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && array[rightIndex] >= key) {
                rightIndex--;
            }
            array[leftIndex] = array[rightIndex];

            while (leftIndex < rightIndex && array[leftIndex] <= key) {
                leftIndex++;
            }
            array[rightIndex] = array[leftIndex];
        }
        array[leftIndex] = key;

        quickSortAsc(array, left, leftIndex - 1);
        quickSortAsc(array, leftIndex + 1, right);
    }

    /**
     * 快速排序,降序排序,时间复杂度=O(nlogn)
     *
     * @param array
     * @return
     */
    public static int[] quickSortDesc(int[] array) {
        System.out.println("快速排序desc:");

        if (array == null) {
            return array;
        }

        quickSortDesc(array, 0, array.length - 1);
        return array;
    }

    public static void quickSortDesc(int[] array, int left, int right) {
        if (left > right) {
            return;
        }

        int key = array[left];

        int leftIndex = left;
        int rightIndex = right;
        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && array[rightIndex] <= key) {
                rightIndex--;
            }
            array[leftIndex] = array[rightIndex];

            while (leftIndex < rightIndex && array[leftIndex] >= key) {
                leftIndex++;
            }
            array[rightIndex] = array[leftIndex];
        }
        array[leftIndex] = key;

        quickSortDesc(array, left, leftIndex - 1);
        quickSortDesc(array, leftIndex + 1, right);
    }

    /**
     * 归并排序, 时间复杂度=O(nlogn)
     *
     * @param array
     * @return
     */
    public static int[] mergeSortAsc(int[] array) {
        System.out.println("归并排序asc:");

        if (array == null) {
            return array;
        }

        mergeSortAsc(array, 0, array.length - 1);
        return array;
    }

    private static void mergeSortAsc(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int center = (left + right) / 2;
        mergeSortAsc(array, left, center);
        mergeSortAsc(array, center + 1, right);
        mergeAsc(array, left, center, right);
    }

    private static void mergeAsc(int[] array, int left, int center, int right) {
        // 临时数组
        int[] temp = new int[array.length];

        int tempIndex = left;
        int leftIndex = left;
        int rightIndex = center + 1;

        while (leftIndex <= center && rightIndex <= right) {
            if (array[leftIndex] <= array[rightIndex]) {
                temp[tempIndex++] = array[leftIndex++];
            } else {
                temp[tempIndex++] = array[rightIndex++];
            }
        }

        while (leftIndex <= center) {
            temp[tempIndex++] = array[leftIndex++];
        }

        while (rightIndex <= right) {
            temp[tempIndex++] = array[rightIndex++];
        }

        while (left <= right) {
            array[left] = temp[left++];
        }
    }

    public static int[] mergeSortDesc(int[] array) {
        System.out.println("归并排序desc:");
        if (array == null) {
            return array;
        }

        mergeSortDesc(array, 0, array.length - 1);
        return array;
    }

    private static void mergeSortDesc(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int center = (left + right) / 2;
        mergeSortDesc(array, left, center);
        mergeSortDesc(array, center + 1, right);
        mergeDesc(array, left, center, right);
    }

    private static void mergeDesc(int[] array, int left, int center, int right) {
        int[] tempArray = new int[array.length];
        int tempIndex = left;
        int leftIndex = left;
        int rightIndex = center + 1;

        while (leftIndex <= center && rightIndex <= right) {
            if (array[leftIndex] >= array[rightIndex]) {
                tempArray[tempIndex++] = array[leftIndex++];
            } else {
                tempArray[tempIndex++] = array[rightIndex++];
            }
        }
        while (leftIndex <= center) {
            tempArray[tempIndex++] = array[leftIndex++];
        }
        while (rightIndex <= right) {
            tempArray[tempIndex++] = array[rightIndex++];
        }
        while (left <= right) {
            array[left] = tempArray[left++];
        }
    }

    /**
     * 把一个数组随机排序.
     *
     * @param array
     * @return
     */
    public static int[] shuffleSort(int[] array) {
        System.out.println("洗牌排序:");

        for (int i = 0; i < array.length; i++) {
            int j = (int) (array.length * Math.random());
            swap(array, i, j);
        }
        return array;
    }

    private static void swap(int[] array, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        final int[] array = new int[] {7, 2, 5, 8, 1, 3, 10, 4, 9, 6};

        System.out.println(Arrays.toString(bubbleSortAsc(Arrays.copyOf(array, array.length))));
        System.out.println(Arrays.toString(bubbleSortDesc(Arrays.copyOf(array, array.length))));

        System.out.println(Arrays.toString(selectSortAsc(Arrays.copyOf(array, array.length))));
        System.out.println(Arrays.toString(selectSortDesc(Arrays.copyOf(array, array.length))));

        System.out.println(Arrays.toString(insertSortAsc(Arrays.copyOf(array, array.length))));
        System.out.println(Arrays.toString(insertSortDesc(Arrays.copyOf(array, array.length))));

        System.out.println(Arrays.toString(quickSortAsc(Arrays.copyOf(array, array.length))));
        System.out.println(Arrays.toString(quickSortDesc(Arrays.copyOf(array, array.length))));

        System.out.println(Arrays.toString(mergeSortAsc(Arrays.copyOf(array, array.length))));
        System.out.println(Arrays.toString(mergeSortDesc(Arrays.copyOf(array, array.length))));

        System.out.println(Arrays.toString(shuffleSort(Arrays.copyOf(array, array.length))));

        final int[] array2 = new int[] {1, 1, 1, 1, 1};
        // 验证快速排序,当数组内所有待排序值相等时,不会死循环
        System.out.println(Arrays.toString(quickSortAsc(array2)));
    }
}
