package dynamicprogramming;

public class CountSubarrayMaxElementKTimes {
    public static void main(String[] args) {
        int[] nums = {1,3,2,3,3};
        int k = 2;
        System.out.println(countSubarrays(nums,k));
    }
    public static int countSubarrays(int[] nums, int k){
        int max = Integer.MIN_VALUE;
        for(int n:nums){
            max = Math.max(max,n);
        }
        int start=0;
        int numOfSubarrays=0;
        int occurrencesOfMax=0;
        for(int end=0;end<nums.length;end++){
            if(nums[end]==max) occurrencesOfMax++;
            while(occurrencesOfMax==k){
                if(nums[start]==max){
                    occurrencesOfMax--;
                }
                start++;
            }
            numOfSubarrays+=start;
        }
        return numOfSubarrays;
    }
}
