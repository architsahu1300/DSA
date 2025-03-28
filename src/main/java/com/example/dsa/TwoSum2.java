package com.example.dsa;

import java.util.Arrays;

public class TwoSum2 {
    public static void main(String[] args) {
        int[] numbers={2,7,11,15};
        int target=9;
        System.out.println(Arrays.toString(TwoSum2(numbers,target)));
    }
    public static int[] TwoSum2(int[] numbers,int target){
        int[] result=new int[2];
        int i=0;
        int j=numbers.length-1;
        while(i<=j){
            if(numbers[i]+numbers[j]==target){
                result[0]=i+1;
                result[1]=j+1;
                break;
            }
            else if(numbers[i]+numbers[j]>target){
                j--;
            }
            else{
                i++;
            }
        }
        return result;
    }
}
