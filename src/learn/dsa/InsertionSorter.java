package learn.dsa;

import java.util.Arrays;

public class InsertionSorter {
    public static void sort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int temp=arr[i];
            int j=i-1;
            while (j>=0&&arr[j]>temp){
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=temp;
        }
    }

    public static void main(String[] args) {
        int [] arr={1,0,45,7,89,34,5,8,66,78};
         sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
