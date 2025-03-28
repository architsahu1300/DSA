package com.example.dsa;

import java.util.HashMap;

public class Anagram {
    public static void main(String[] args) {
        String s="anagram";
        String t="nagaram";
        System.out.println(ValidAnagram(s,t));
    }
    public static boolean ValidAnagram(String s,String t){
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer> hmap=new HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++){
            if(hmap.containsKey(s.charAt(i))) {
                hmap.put(s.charAt(i),hmap.get(s.charAt(i))+1);
            }
            else{
                hmap.put(s.charAt(i),1);
            }
        }
        System.out.println(hmap.keySet());
        System.out.println(hmap.values());
        for(int i=0;i<t.length();i++){
            if(hmap.containsKey(t.charAt(i))){
                hmap.put(t.charAt(i),hmap.get(t.charAt(i))-1);
            }
            else{
                return false;
            }
        }
        for(Integer i:hmap.values()){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
    public static boolean ValidAnagramOptimised(String s,String t){
        if(s.length()!=t.length()) return false;
        int[] sArr=new int[128];
        for(int i=0;i<s.length();i++){
            sArr[s.charAt(i)]++;
        }
        for(int i=0;i<t.length();i++){
            if(sArr[t.charAt(i)]==0) return false;
            sArr[t.charAt(i)]--;
        }
        return true;
    }
}
