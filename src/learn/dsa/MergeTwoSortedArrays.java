package learn.dsa;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static int [] merge(int [] arr1,int[] arr2,int n,int m){
        int [] result=new int[n+m];
        int i=0;
        int j=0;
        int k=0;
        while(i<n&&j<m){
            if(arr1[i]<arr2[j]){
                result[k++]=arr1[i];
                i++;
            }else {
                result[k++]=arr2[j];
                j++;
            }
        }
        while (i<n){
            result[k++]=arr1[i];
            i++;
        }
        while (j<m){
            result[k++]=arr2[j];
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        int [] arr1={1,4,6,7};
        int [] arr2={2,5,6,8};
        int [] result=merge(arr1,arr2,arr1.length,arr2.length);
        System.out.println(Arrays.toString(result));
    }
}
