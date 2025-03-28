package com.example.dsa;

import java.util.HashSet;

public class HappyNumber {
    public static void main(String[] args) {
        int n=19;
        System.out.println(isHappyRecursive(n));
    }
    public static boolean isHappy(int n) {
        //We want to identify if we are in a loop.
        //Keep a set to check if we have encountered a number before.
        HashSet<Integer> seen=new HashSet<>();
        int sum=0;
        while(sum!=1 && !seen.contains(sum)){
            seen.add(sum);
            sum=0;
            while(n!=0){
                sum+=Math.pow(n%10,2);
                n/=10;
            }
            n=sum;
        }
        return sum==1;
    }
    public static boolean isHappyRecursive(int n){
        //Base condition as 1 and 7 are single digit happy numbers
        if(n==1 || n==7) return true;
        if(n<10) return false;
        int sum=0;
        while(n!=0){
            sum+=Math.pow(n%10,2);
            n/=10;
        }
        return isHappyRecursive(sum);
    }
}
