package com.example.dsa;

public class AddBinary {
    public static void main(String[] args) {
        String a="1010";
        String b="1011";
        String result=addBinary(a,b);
        System.out.println(result);
    }
    public static String addBinary(String a,String b){
        //StringBuilder creates a mutable string
        StringBuilder result=new StringBuilder();
        //We want to loop backwards to both strings
        int i=a.length()-1;
        int j=b.length()-1;
        int carry=0;
        while(i>=0||j>=0){
            int sum=carry;
            // - '0' because we subtract ascii of '0' which is 48 from charAt(i) which can be '1' or '0' hence we get actual sum as int
            //if conditions to avoid index out of bounds in case one string is over before other
            if(i>=0) sum+=a.charAt(i) - '0';
            if(j>=0) sum+=b.charAt(j) - '0';
            result.append(sum%2);
            carry=sum/2;
            i--;
            j--;
        }
        //Append remaining carry
        //Reverse the string as no method to append in front for StringBuilder
        if(carry!=0) result.append(carry);
        return result.reverse().toString();
    }
}
