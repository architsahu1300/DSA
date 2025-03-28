package com.example.dsa;

public class JumpGame2 {
    public static void main(String[] args) {
        int[] nums={1,2,0,1,1,2,0,4,0,0,0,1};
        int result=jumpGame(nums);
        System.out.println(result);
    }
    public static int jumpGame(int[] nums){
        //Idea is to take left and right pointers which represent the current window we can reach from previous window.
        //From current window we will check how far we can go from all possible options in current window till we reach destination.
        int destination=nums.length-1;
        int left=0;
        int right=0;
        int steps=0;
        //right<destination because if right has already reached destination we are at the result point
        while(right<destination){
            //To check how far we can reach in current window
            int maxReach=0;
            for(int i=left;i<right+1;i++){
                maxReach=Math.max(maxReach,i+nums[i]);
            }
            //Moving the window forward to next reachable window (left as next element to current right and right to next maxReach
            left=right+1;
            right=maxReach;
            steps++;
        }
        return steps;

    }
}
