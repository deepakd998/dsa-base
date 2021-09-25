package learn.dsa;

import java.util.Arrays;

public class MergeSorter {
    public void sort(int[] arr) {
        applyMergeSort(arr, new int[arr.length], 0, arr.length-1);
    }

    private void applyMergeSort(int[] arr, int[] temp, int l, int h) {
        if (l < h) {
            int mid = (l + h )/ 2;
            applyMergeSort(arr, temp, l, mid);
            applyMergeSort(arr, temp, mid + 1, h);
            merge(arr, temp, l, mid, h);
        }
    }

    private void merge(int[] arr, int[] temp, int l, int mid, int h) {
        for (int i = l; i <= h; i++) {
            temp[i] = arr[i];
        }
        int i = l;
        int j = mid + 1;
        int k = l;

        while (i <= mid && j <= h) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            arr[k] = temp[i];
            k++;
            i++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 45, 7, 89, 34, 5, 8, 66, 78,-1,-8};
        new MergeSorter().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
