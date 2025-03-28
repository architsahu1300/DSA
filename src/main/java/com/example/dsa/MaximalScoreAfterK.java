package com.example.dsa;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximalScoreAfterK {
    public static void main(String[] args) {
        int[] nums= {10,10,10,10,10};
        int k=3;
        System.out.println(MaximalScoreAfterApplyingKOperations(nums,k));
    }
    public static long MaximalScoreAfterApplyingKOperations(int[] nums,int k){
        long score=0;
        //By default priority queue is min heap in java
        //We are making this max heap by adding comparator as Collections.reverseOrder()
        //So now instead of min, the max element will be in front of the queue
        PriorityQueue<Long> qu=new PriorityQueue<>(Collections.reverseOrder());
        //We are casting to long so that we can compare to queue if score goes beyong int range
        for(int i:nums){
            qu.add((long)i);
        }
        while(k-- >0){
            long curr=qu.poll();
            score+=curr;
            curr=(long)Math.ceil((double)curr/3);
            qu.add(curr);
        }
        return score;
    }
}
