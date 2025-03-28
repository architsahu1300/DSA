package com.example.dsa;

import java.util.HashMap;
import java.util.HashSet;


//Brute force is increment the numbers by 1 and check in array if they exist and go on to check the max length
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr={3,7,2,5,10,11,15,4,6,0,1};
        System.out.println(approach2(arr));
    }
    public static int approach1Fail(int[] nums){
        //Below approach is almost correct except for some cases where the sequence does not start with smallest numbers in the arr
        //Ex: [-1,0,1,5,4,7,6,8]
        //In above example the longest sequence starts with 4 which is not minimum.
        //To optimize this we need to change the condition to check if HashSet contains n-1 number, if yes then we don't check for this number
        //Because it will be checked in the future anyways.
        if(nums.length==0) return 0;
        int min=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<min){
                min=nums[i];
            }
        }
        HashMap<Integer,Integer> hmap=new HashMap<>();
        for(int i:nums){
            hmap.put(i,1);
        }
        int result=0;
        while(hmap.containsKey(min)){
            result++;
            min++;
        }
        return result;
    }
    public static int approach2(int[] nums){
        //Keeping a hashset to keep track of already visited numbers
        HashSet<Integer> hset=new HashSet<>();
        for(int i:nums){
            hset.add(i);
        }
        int max_seq=0;
        for(int i=0;i<nums.length;i++){
            //curr_seq starts from 1 because we are assuming this is the first number of the sequence
            int curr_seq=1;
            int curr_num=nums[i];
            //Checking if curr_num-1 exists in the set, if curr_num=4 and 3 exists in the set,
            // we don't want to check for this sequence as we will start to check for sequence from smallest number in the sequence
            if(!hset.contains(curr_num-1)){
                //Here we have reached smallest number in the sequence till now so now we loop till we have the sequence
                while(hset.contains(curr_num+1)){
                    curr_num++;
                    curr_seq++;
                }
            }
            max_seq=Math.max(curr_seq,max_seq);
        }
        return max_seq;
    }
}
