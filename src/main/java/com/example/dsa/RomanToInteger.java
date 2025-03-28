package com.example.dsa;

import org.jboss.classfilewriter.annotations.StringAnnotationValue;

public class RomanToInteger {
    public static void main(String[] args) {
        String s="MCMXCIV";
        int result=RomanToInt(s);
        System.out.println(result);

    }
    private static int translate(char c){
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
    public static int RomanToInt(String s){
        int result=0;
        int curr= translate(s.charAt(0));
        for(int i=1;i<s.length();i++){
            int next=translate(s.charAt(i));
            if(curr<next){
                result-=curr;
            }
            else{
                result+=curr;
            }
            curr=next;
        }
        result+=curr;
        return result;

    }
}
