package com.example.dsa;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,2,1,2,2,2,2,4,5,6,2,2,2,2,6,21};
        System.out.println(majorityElement(nums));
    }
    public static int majorityElement(int[] nums) {
        //Moore's Voting Algorithm
        //Ensures that if majority element is present more than n/2 times, then it will always remain in lead at the end
        int count=0;
        int candidate=nums[0];
        for(int i=0;i<nums.length;i++){
            if(count==0) candidate = nums[i];
            if(nums[i]==candidate) count++;
            else count--;
        }
        return candidate;

        //Hashmap appproach which takes O(n) space
//        int n=nums.length;
//        HashMap<Integer,Integer> somemap = new HashMap<>();
//        for(int i=0;i<n;i++){
//            somemap.put(nums[i],somemap.getOrDefault(nums[i],0)+1);
//        }
//        n=n/2;
//        for(Map.Entry<Integer,Integer> entry: somemap.entrySet()){
//            if(entry.getValue()>n){
//                return entry.getKey();
//            }
//        }
//        return 0;
    }
}
