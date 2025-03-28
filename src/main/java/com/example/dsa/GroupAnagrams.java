package com.example.dsa;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs={"eat","tea","tan","ate","nat","bat"};
        System.out.println(grouped(strs));
    }
    public static List<List<String>> grouped(String[] strs){
        //We are going to map the count of characters in a string to the list of anagrams
        HashMap<String,List<String>> anagrams=new HashMap<>();
        for(String s:strs){
            //We know 26 alphabets is the given limit for characters in any string
            int[] count=new int[26];
            for(char c:s.toCharArray()){
                count[c-'a']+=1;
            }

        }
        return null;
    }
}
