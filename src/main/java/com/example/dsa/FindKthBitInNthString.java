package com.example.dsa;

public class FindKthBitInNthString {
    public static void main(String[] args) {
        int n=3;
        int k=1;
        System.out.println(findKthBit(n,k));
    }
    public static char findKthBit(int n, int k){
        String sn=getNthString(n);
        System.out.println(sn);
        return sn.charAt(k-1);
    }
    public static String getNthString(int n){
        if(n==1) return "0";
        String prev = getNthString(n-1);
        return prev + "1" + reverse(inverse(prev));
    }
    public static String inverse(String s){
        char[] cArr=s.toCharArray();
        for(int i=0;i<cArr.length;i++){
            cArr[i]=(char)(Integer.parseInt(String.valueOf(cArr[i]))^1 + '0');
        }
        return String.valueOf(cArr);
    }
    public static String reverse(String s){
        StringBuilder sb=new StringBuilder(s);
        return String.valueOf((sb.reverse()));
    }
}
