package dynamicprogramming;

public class SubetSumRecursive {
    public static void main(String[] args) {
        int[] nums = {2,3,7,8,10};
        int sum = 11;
        int len = nums.length;
        System.out.println(isSubsetPresent(nums,sum,len));
    }
    public static boolean isSubsetPresent(int[] nums,int sum,int len){
        //Empty subset condition
        if(sum==0) return true;
        if(len==0 && sum!=0) return false;
        if(nums[len-1]<=sum){
            return isSubsetPresent(nums,sum-nums[len-1],len-1)
                    || isSubsetPresent(nums,sum,len-1);
        }
        else{
            return isSubsetPresent(nums,sum,len-1);
        }
    }
}
