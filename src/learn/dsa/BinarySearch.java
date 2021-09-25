package learn.dsa;

import java.util.Arrays;

public class BinarySearch {
    public static int search(int [] arr,int x){
        int n=arr.length;
        if(n==0){
            return -1;
        }
        Arrays.sort(arr);
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==x) return mid;
            if(x>arr[mid]){
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] arr={1,0,45,7,89,34,5,8,66,78};
        int index=search(arr,45);
        System.out.println(index);
    }
}
