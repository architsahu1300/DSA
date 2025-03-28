package com.example.dsa;

import java.util.Arrays;
import java.util.HashMap;

public class RankTransformOfArray {
    public static void main(String[] args) {
        int[] arr={40,10,20,60,90,20};
        //Aim is to assign rank to every element of the array. So in above array answer would be {3,1,2,4,5,2}
        int[] ans=rankTransform(arr);
        for(int i:ans) {
            System.out.println(i);
        }
    }
    public static int[] rankTransform(int[] arr){
        //The approach here is that we sort the array to get the ranks of every number in array
        //Store these ranks corresponding to the numbers in hashmap so while putting in original array we can get the rank in O(1) time
        int[] ans=arr.clone();
        Arrays.sort(arr);
        HashMap<Integer, Integer> hmap=new HashMap<>();
        for(int i:arr){
            if(!hmap.containsKey(i)){
                hmap.put(i,hmap.size()+1);
            }
        }
        for(int i=0;i<ans.length;i++){
            ans[i]=hmap.get(ans[i]);
        }
        return ans;
    }
}
