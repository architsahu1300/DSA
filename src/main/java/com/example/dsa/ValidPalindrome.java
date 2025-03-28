package com.example.dsa;

import java.io.CharConversionException;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s="race, car";
        StringBuilder new_string= new StringBuilder();
        for (Character c: s.toCharArray()){
            if(Character.isDigit(c)||Character.isLetter(c)){
                new_string.append(c);
            }
        }
        int start=0;
        int end=new_string.length()-1;
        new_string = new StringBuilder(new_string.toString().toLowerCase());
        while(start<=end){
            if(new_string.charAt(start)!=new_string.charAt(end)){
                //return false;
            }
            start++;
            end--;
        }
        //return true;
    }
}
