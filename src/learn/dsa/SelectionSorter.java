package learn.dsa;

import java.util.Arrays;

public class SelectionSorter {
    public static void sort(int [] arr){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            int min=i;
            for(int j=i;j<n;j++){
                if(arr[min]>arr[j]){
                    min=j;
                }
            }
            int temp=arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
        }
    }

    public static void main(String[] args) {
        int [] arr={1,0,45,7,89,34,5,8,66,78};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
