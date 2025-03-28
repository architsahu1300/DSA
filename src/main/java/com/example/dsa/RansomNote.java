package com.example.dsa;

import java.util.HashMap;

public class RansomNote {
    public static void main(String[] args) {
        String a="aa";
        String b="ab";
        System.out.println(canConstruct(a,b));
    }
    public static boolean canConstruct(String a,String b){
        //Keeping hashmap to store count of all characters occurring in the String1 so while looping through String2 we can count
        //and see if it is possible to construct String2 using characters in String1
        HashMap<Character,Integer> hMap=new HashMap<>();
        for(char c:b.toCharArray()){
            //Here we are putting key "c" against the value which initially by default will be 0
            // and incremented whenever we encounter the current character repeatedly
            hMap.put(c,hMap.getOrDefault(c,0)+1);
        }
        //Now checking if String2 can be constructed
        for(char c:a.toCharArray()){
            //If the letter used in String2 is not even present in hashmap or the number of c's present are already used
            if(!hMap.containsKey(c) || hMap.get(c)<=0){
               return false;
            }
            //Using up one of the occurrences of c from the hashmap
            hMap.put(c,hMap.get(c)-1);
        }
        return true;
    }
}
