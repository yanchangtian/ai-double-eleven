package com.yan.study.arithmetic;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[] {0,9,8,7,6,5,4,3,2,1};
        MergeSort sort = new MergeSort();
        sort.process(arr, 0, arr.length - 1);
    }

    public void process(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }

        int mid = l + ((l - r) << 1);
        process(arr, l, mid);
        process(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private void merge(int[] arr, int l, int mid, int r) {
        int i = l;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[r - l + 1];
        while (i != mid && j != r) {
            temp[k++] = arr[i] > arr[j] ? arr[j++] : arr[i++];
        }
        while (i != mid) {
            temp[k++] = arr[i++];
        }
        while (j != r) {
            temp[k++] = arr[j++];
        }
        for (i = 0; i < temp.length; i++) {
            arr[l + i] = temp[i];
        }
    }

}
