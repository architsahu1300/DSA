package com.example.dsa;

import org.jboss.classfilewriter.constpool.ClassEntry;

import java.util.ArrayList;

public class MaximumSwap {
    public static void main(String[] args) {
        int num=99364;
        System.out.println(maxSwap(num));
    }
    public static int maxSwap(int num){
        //BRUTE FORCE:
        //We go from left to right anc check for every number if there is a number bigger than itself
        //If so then we swap O(n^2)

        //OPTIMISED:
        //We want to avoid repetitive task of looking for max value to right of every element, so we scan from right to left
        char[] cArr=String.valueOf(num).toCharArray();
        //We don't have to put max values in the maxArray, instead we can keep the index of max value so that it will help with swapping later
        int[] maxIndexArr=new int[cArr.length];
        int maxIndex=cArr.length-1;
        for(int i=cArr.length-1;i>=0;i--){
            if(cArr[i]>cArr[maxIndex]){
                maxIndex=i;
            }
            maxIndexArr[i]=maxIndex;
        }
        for(int i=0;i<cArr.length-1;i++){
            if(cArr[i]<cArr[maxIndexArr[i]]){
                char temp=cArr[i];
                cArr[i]=cArr[maxIndexArr[i]];
                cArr[maxIndexArr[i]]=temp;
                break;
            }
        }
        return Integer.parseInt(new String(cArr));
    }
}
