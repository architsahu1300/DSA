package dynamicprogramming;

public class MatrixChainMultiplicationRecursive {
    public static void main(String[] args) {
        int[] arr = {40,20,30,10,30};
        int i = 1;
        int j = arr.length-1;
        System.out.println(solve(arr,i,j));
    }
    public static int solve(int[] arr, int i, int j){
        if(i>=j) return 0;
        int mn = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int temp = solve(arr,i,k)+solve(arr,k+1,j)+arr[i-1]*arr[k]*arr[j];
            if(temp<mn){
                mn=temp;
            }
        }
        return mn;
    }
}
