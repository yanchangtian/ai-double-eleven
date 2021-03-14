package com.yan.study.arithmetic.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题
 *  1. 在一个数组中, 一个数左边比它小的数的总和, 叫数的小和, 所有数的小和累加起来, 叫数组的小和.
 *  求数组的小和 [1, 3, 4, ,2, 5]
 *
 *
 */
public class MergeSort {

    public Integer sum = 0;

    public static void main(String[] args) {
        int[] arr = new int[] {1,9,8,7,6,5,4,3,1,2,1};
        MergeSort sort = new MergeSort();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
        int sum = sort.process01(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
        System.out.println(sum);
    }

    public void process(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        process(arr, l, mid);
        process(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private void merge(int[] arr, int l, int mid, int r) {
        int a = l;
        int b = mid + 1;
        int c = 0;
        int[] help = new int[r - l + 1];
        while (a <= mid && b <= r) {
            // help[c++] = arr[a] < arr[b] ? arr[a++] : arr[b++];
            if (arr[a] < arr[b]) {
                sum += (r - b + 1) * arr[a];
                help[c++] = arr[a++];
            } else {
                help[c++] = arr[b++];
            }
        }
        while (a <= mid) {
            help[c++] = arr[a++];
        }
        while (b <= r) {
            help[c++] = arr[b++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }

    // ----- 小数和 -----

    public int process01(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process01(arr, l, mid) + process01(arr, mid + 1, r) + merge01(arr, l, mid, r);
    }

    private int merge01(int[] arr, int l, int mid, int r) {
        int a = l;
        int b = mid + 1;
        int c = 0;
        int res = 0;
        int[] help = new int[r - l + 1];
        while (a <= mid && b <= r) {
            res += arr[a] < arr[b] ? arr[a] * (r - b + 1) : 0;
            help[c++] = arr[a] < arr[b] ? arr[a++] : arr[b++];
        }
        while (a <= mid) {
            help[c++] = arr[a++];
        }
        while (b <= r) {
            help[c++] = arr[b++];
        }
        if (help.length >= 0) System.arraycopy(help, 0, arr, l + 0, help.length);
        return res;
    }

    // ----- 降序对 -----

}
