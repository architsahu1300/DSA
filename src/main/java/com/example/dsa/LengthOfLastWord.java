package com.example.dsa;

public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
    }
    public static int lengthOfLastWord(String s) {
        String[] sArr = s.split(" ");
        return sArr[sArr.length - 1].length();
    }
}
