package com.example.dsa;

import java.util.HashMap;

public class TupleWithSameProduct {
    public static void main(String[] args) {
        int[] nums = {1,2,4,5,10};
        System.out.println(numberOfTuples(nums));
    }
    public static int numberOfTuples(int[] nums) {
        //Find the sum of all numbers with one another using nested loop and store in Map
        //Each key in this map is a product of pair of numbers.
        //If the value for any key is >=2 it means two different pair of numbers gave the same product, and they satisfy the condition a*b=c*d
        //Any 2 pair of numbers (a*b)=(c*d) will give a total of 8 permutations
        //(a,b,c,d)  -> (c,d,a,b)
        //(b,a,c,d)  -> (c,d,b,a)
        //(a,b,d,c)  -> (d,c,a,b)
        //(b,a,d,c)  -> (d,c,b,a)
        //If some product gives 3 value it means there can be 3*8 permutations (c1,c2),(c2,c3),(c1,c3)*8
        //Similarly if any product has 4 as value then 6*8 possibilities
        // n*(n-1)/2*8 possibilities for n occurrences of any product.
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                map.put(nums[i]*nums[j], map.getOrDefault(nums[i]*nums[j], 0) + 1);
            }
        }
        int result=0;
        for(int i:map.values()) {
            result+=(i*(i-1)/2)*8;
        }
        return result;
    }
}
