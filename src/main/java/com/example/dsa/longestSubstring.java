package com.example.dsa;

import java.util.HashSet;

public class longestSubstring {
    public static void main(String[] args) {
        String s="ababcbb";
        int len=longestSubstring(s);
        System.out.println(len);
    }
    public static int longestSubstring(String s){
        //Sliding window problem.
        //We will use two pointers and keep track of window and keep updating maximum

        int i=0;
        int j=0;
        int max=0;
        HashSet<Character> hash_set=new HashSet<>();
        while(j<s.length()){
            //if character is not present in the hashset, i.e., it is a new character add the character
            // and increase the window size and update max.
            if(!hash_set.contains(s.charAt(j))){
                hash_set.add(s.charAt(j));
                j++;
                max=Math.max(hash_set.size(),max);
            }
            //If the char is already present in the hashset,i.e., repeated char,
            // then we remove the first char and check further for longest substring.
            //Since max is already updated we don't have to do anything here
            else{
                hash_set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}
