package com.example.dsa;

import java.util.HashMap;

public class WordPattern {
    //Logic same as isomorphic strings
    public static void main(String[] args) {
        String pattern="acca";
        String s="cat dog dog cat";
        System.out.println(isPattern(pattern,s));
    }
    public static boolean isPattern(String pattern, String s){
        String[] str=s.split(" ");
        if(str.length!=pattern.length()) return false;
        System.out.println(pattern.length());
        HashMap<String, Character> hmap=new HashMap<>();
        for(int i=0;i<str.length;i++){
            if(!hmap.containsKey(pattern.charAt(i))){
                hmap.put(str[i],pattern.charAt(i));
            }
            else{
                if(pattern.charAt(i)!=hmap.get(str[i])){
                    return false;
                }
            }
        }
        return true;
    }
}

//Key: cat
//Value: a

