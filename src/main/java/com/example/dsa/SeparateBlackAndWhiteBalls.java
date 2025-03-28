package com.example.dsa;

import java.util.Arrays;

public class SeparateBlackAndWhiteBalls {
    public static void main(String[] args) {
        String s="10010";
        System.out.println(separateBAndWBalls(s));
    }
    public static long separateBAndWBalls(String s){
        //We start from end and keep counting steps required to bring 1 to its correct position and change the required position of 1
        //for 10010, the 1 at index 3 needs 1 step (correctPositionOf1[4]-index[3]) to be in its correct position
        //the 1 at index 0 requires 3 steps (correctPositionOf1[3]-index[0]) to be in its correct position
        int correctPositionOf1=s.length()-1;
        long steps=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='1'){
                steps+=correctPositionOf1-i;
                correctPositionOf1--;
            }
        }
        return steps;
    }
}
