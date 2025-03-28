package com.example.dsa;

public class FirstOccurenceIndex {
    public static void main(String[] args) {
        String haystack="bhsdhhtak";
        String needle="sad";
        //We check in haystack by decreasing its size whether needle is present or not and return the first occurence index
        int result=haystack.indexOf(needle);
        System.out.println(result);
    }
}
