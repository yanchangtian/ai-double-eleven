package com.yan.study.arithmetic.sort;

/**
 * 快速排序
 *
 *
 */
public class QuickSort {

    /**
     * partition(分2段, 小于 - 大于等于)
     *
     * 给定一个数组 arr, 和一个整数 num. 请把小于等于 num 的数放在数组的左边, 大于 num 的数放在数组的右边.
     *
     * 要求额外空间复杂度O(1), 时间复杂度O(N)
     */
    public static int partition(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int less = L - 1;
        int index = L;
        while (index < R) {
            if (arr[index] <= arr[R]) {
                swap(arr, index, ++less);
            }
            index++;
        }
        swap(arr, R, ++less);
        return less;
    }

    /**
     * 荷兰国旗问题(分3段, 小于 - 等于 - 大于)
     *
     * 给定一个数组 arr, 和一个整数 num. 请把小于 num 的数放在数组的左边, 等于 num 的数放在中间, 大于 num 的数放在数组的右边.
     *
     * 要求额外空间复杂度O(1), 时间复杂度O(N)
     */
    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L > R) {
            return new int[] {-1, -1};
        }
        if (L == R) {
            return new int[] {L, L};
        }
        int less = L - 1;
        int more = R;
        int index = L;
        while (index < R) {
            if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else if (arr[index] == arr[R]) {
                index++;
            } else {
                swap(arr, index, --more);
            }
        }
        swap(arr, more, R);
        return new int[] {less + 1, more};
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 快速排序 1.0
    public static void quickSort01(int[] arr) {

    }

    public static void process01(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = partition(arr, l, r);
        process01(arr, l, i - 1);
        process01(arr, i + 1, r);
    }

    // 快速排序 2.0
    public static void process02(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int[] i = netherlandsFlag(arr, l, r);
        process02(arr, l, i[0] - 1);
        process02(arr, i[1] + 1, r);
    }


    // 快速排序 3.0


}
