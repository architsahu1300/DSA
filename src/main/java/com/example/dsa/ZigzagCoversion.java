package com.example.dsa;

public class ZigzagCoversion {
    public static void main(String[] args) {
        String s="PAYPALISHIRING";
        int n=4;
        System.out.println(zigzag(s,n));
    }
    public static String zigzag(String s,int numRows){
        int n=s.length();
        StringBuilder str=new StringBuilder();
        int k=(numRows-1)*2;
        for(int i=0;i<numRows;i++){
            int index=i;
            //P     I     N
            //A   L S   I G
            //Y A   H R
            //P     I
            //We want to add all ith row elements into our answer
            while(index<n){
                str.append(s.charAt(index));
                //This if condition fills the rows other than first and last rows
                //Because the formula for 1st and last rows is just index + k (calculated above)
                if(i!=0 && i!=numRows-1){
                    //Formula for rows other than 1st and last row
                    //Here the formula for rows=4 is 6-2(i)
                    //Above diagram in row 1, we go from A to L using above formula, from L to S we automatically go using index=index+k
                    //Because from A to S is 6 (4+2) and we appended L using a separate variable k2
                    int k1=k-2*i;
                    int k2=index + k1;
                    if(k2<n) {
                        str.append(s.charAt(k2));
                    }
                }
                index=index+k;
            }
        }
        return str.toString();
    }
}
