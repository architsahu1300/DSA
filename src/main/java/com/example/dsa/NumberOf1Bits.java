package com.example.dsa;

public class NumberOf1Bits {
    public static void main(String[] args) {
        int n=128;
        System.out.println(approach1(n));
    }
    public static int approach1(int n){
        //We will use helper bits.
        //1011 & 0001 = 0001
        //1011 & 0010 = 0010
        //1011 & 0100 = 0000
        //1011 & 1000 = 1000
        //We will count whenever result != 0
        int result=0;
        int helper=1;
        for(int i=0;i<32;i++){
            if((helper&n)!=0){
                result++;
            }
            helper=helper<<1;
        }
        return result;
    }
    public static int approach2(int n){
        //n & n-1 until n =0
        //What this does is it flips the least significant bit's 1 to 0
        //1000101
        //1000100
        //1000100

        //1000100
        //1000011
        //1000000

        //1000000
        //0111111
        //0000000
        int result=0;
        while(n!=0){
            n=n&(n-1);
            result++;
        }
        return result;
    }
}
