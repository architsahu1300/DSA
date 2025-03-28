package com.example.dsa;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2 {
    public static void main(String[] args) {
        int[] arr={1,2,4,5,3,2,9,8,2,5};
        int k=2;
        System.out.println(hasDuplicate2(arr,k));
    }
    public static boolean hasDuplicate2(int[] nums,int k){
        Map<Integer,Integer> hmap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            //Checking if HashMap contains the current number as key and i-p<=k
            if(hmap.containsKey(nums[i])){
                int p=hmap.get(nums[i]);
                if(Math.abs(p-i)<=k) return true;
            }
            else {
                //If not present(or present but index does not match the condition yet, in this case the new index is updated)
                //then we add the number as the key and its index as value to HashMap
                hmap.put(nums[i],i);
            }
        }
        return false;
    }
}
