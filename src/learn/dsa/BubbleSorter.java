package learn.dsa;

import java.util.Arrays;

public class BubbleSorter {
    public static int [] sort(int [] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int [] arr={1,0,45,7,89,34,5,8,66,78};

        System.out.println(Arrays.toString(sort(arr)));
    }
    /*
    {0,1,7,45,34,89,5,8,66,78}

     */
}
