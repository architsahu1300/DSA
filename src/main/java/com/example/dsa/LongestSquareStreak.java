package com.example.dsa;

import java.util.*;

public class LongestSquareStreak {
    public static void main(String[] args) {
        int[] nums={4,3,6,16,8,2};
        System.out.println(longestStreak(nums));
    }
    public static int longestStreak(int[] nums){

        //APPROACH 1 using sorting
//        int max=-1;
//        //Approach is that we sort the array first, then check if root of i are present previously and increase the length of sequence
//        Map<Integer,Integer> currStreakOfEachElement=new HashMap<>();
//        Arrays.sort(nums);
//        for(int i:nums){
//            int root=(int) Math.sqrt(i);
//            //Check if i is a perfect square and if streak contains the root of i
//            if(root*root==i && currStreakOfEachElement.containsKey(root)){
//                currStreakOfEachElement.put(i,currStreakOfEachElement.get(root)+1);
//                max=Math.max(max,currStreakOfEachElement.get(i));
//            }
//            else{
//                //Putting current element to mark that we have a seq with i and its length is currently 1
//                currStreakOfEachElement.put(i,1);
//            }
//        }
//        return max;

        //APPROACH 2 without sorting
        //Logic is that we will use a set to keep visited numbers and while looping through each number we will check if
        //its square is present in the set. If present then we will increase the current streak length
        //In this approach we have constraints that any number cannot exceed 10^5, so in worst case if we are checking for squares of 2,
        //Our inner while loop will run only 5 times hence the time complexity for this approach becomes O(n)
        int max=0;
        Set<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        for(int i:nums){
                int length=0;
                long temp=i;
                while(set.contains((int)temp)){
                    length++;
                    //Break condition because of the constraints
                    if(temp*temp>100000) break;
                    temp=temp*temp;
                }
                max=Math.max(max,length);
        }
        return max<2?-1:max;


    }
}
