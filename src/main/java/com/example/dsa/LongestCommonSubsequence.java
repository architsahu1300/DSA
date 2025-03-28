package com.example.dsa;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String[] strs={"flower","flow","flight"};
        Arrays.sort(strs);
        int i=0;
        while(strs[0].charAt(i)==strs[strs.length-1].charAt(i)){
            i++;
        }
        String result=strs[strs.length-1].substring(0,i-1);
        //return result;
    }
}
