package learn.dsa;

public class SearchInSortedMatrix {
    public void search(int[][] matrix,int n,int x){
        int i=0;
        int j=n-1;
        while (i<n&&j>=0){
            if(matrix[i][j]==x){
                System.out.print("Found at row "+i+" column"+j);
                return;
            }
            if(matrix[i][j]>x){
                j--;
            }else {
                i++;
            }
        }
    }
}
