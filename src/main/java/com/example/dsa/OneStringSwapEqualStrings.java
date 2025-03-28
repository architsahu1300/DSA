package com.example.dsa;

import java.util.ArrayList;

public class OneStringSwapEqualStrings {
    public static void main(String[] args) {
        String s1="bank";
        String s2="kanb";
        System.out.println(almostEqual(s1,s2));
    }
    public static boolean almostEqual(String s1,String s2) {
        if(s1.equals(s2)) return true;
        if(s1.length()!=s2.length()) return false;
        ArrayList<Integer> indices = new ArrayList<>();
        for(int i=0;i<s1.length();i++) {
            if(s1.charAt(i)!=s2.charAt(i)) indices.add(i);
        }
        if(indices.size()!=2) return false;
        int i1=indices.get(0);
        int i2=indices.get(1);
        return s1.charAt(i1) == s2.charAt(i2) && s1.charAt(i2) == s2.charAt(i1);
    }
}
