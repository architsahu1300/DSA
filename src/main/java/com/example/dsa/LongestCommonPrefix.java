package com.example.dsa;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] str={"flower","flow","flight"};
        //Method 1
        //Take first string and compare each char of prefix to current string
        String prefix=str[0];
        for(int i=1;i<str.length;i++){
            //While the index of "flower"(prefix) in "flow"(current string) is not equal to 0
            while(str[i].indexOf(prefix)!=0){
                prefix=prefix.substring(0,prefix.length()-1);
            }
        }
        System.out.println(prefix);
    }
}
//prefix="flower";
//["flow","flight"]
