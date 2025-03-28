package com.example.dsa;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        //String may contain leading/trailing/underlying extra spaces but output should contain only 1 space
        String s = "   Let's take LeetCode    contest";
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=words.length-1; i>=1; i--) {
            sb.append(words[i]).append(" ");
        }
        sb.append(words[0]);
        return sb.toString();
    }
}
