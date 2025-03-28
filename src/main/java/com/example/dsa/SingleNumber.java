package com.example.dsa;

public class SingleNumber {
    public static void main(String[] args) {
        int[] arr={4,1,2,1,2};
        System.out.println(singleNumber(arr));
    }
    public static int singleNumber(int[] nums) {
        int value=0;
        //Applying bitwise XOR
        //Whenever same number is encountered we will get 0 else 1
        //Hence in the end single number will remain
        //Basically 4^1^2^1^2 can be written as 4^(1^1)^(2^2) -> 4^0^0 -> 4
        for(int i=0;i<nums.length;i++){
            value=value^nums[i];
        }
        return value;
    }
}
