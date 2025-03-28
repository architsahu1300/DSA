package com.example.dsa;

public class isSubsequence {
    public static void main(String[] args) {
        String s1="acj";
        String s2="affcgghj";
        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        int first=0;
        int second=0;
        while(first<c1.length && second<c2.length){
            System.out.println(c1[first] +" - "+c2[second]);
            if(c1[first]==c2[second]){
                first++;
                second++;
            }
            else{
                second++;
            }
        }
        System.out.println(first+","+second+","+c1.length);
        System.out.println(first==(c1.length));
        //return first==c1.length+1;
    }
}
