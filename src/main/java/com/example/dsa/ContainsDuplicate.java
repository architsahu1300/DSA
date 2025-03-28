package com.example.dsa;

import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] arr={1,4,6,2,5,8,2};
        System.out.println(hasDuplicate(arr));
    }
    public static boolean hasDuplicate(int[] arr){
        HashSet<Integer> hset=new HashSet<>();
        for(int i:arr){
            if(hset.contains(i)){
                return true;
            }
            hset.add(i);
        }
        return false;
    }
}
