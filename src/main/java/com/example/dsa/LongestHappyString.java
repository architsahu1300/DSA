package com.example.dsa;

public class LongestHappyString {
    public static void main(String[] args) {
        int a=3;
        int b=1;
        int c=7;
        System.out.println(longestHappyString(a,b,c));
    }
    public static String longestHappyString(int a,int b,int c){
        //Approach is that we always select the character with maximum value because we are trying to get "longest" happy string
        //But we cannot keep 3 same characters consecutively hence we will keep a break in between
        //We are using a greedy approach since the order of string doesn't matter
        //We will keep counters of each character and bring a break in between whenever any character reaches 2
        int maxlen=a+b+c;
        int ca=0, cb=0,cc=0;
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<maxlen;i++){
            if((a>=b && a>=c && ca!=2) || (cb==2 && a>0) || (cc==2 && a>0)){
                sb.append("a");
                a--;
                ca++;
                cb=0;
                cc=0;
            }else if((b>=a && b>=c && cb!=2) || (ca==2 && b>0) || (cc==2 && b>0)){
                sb.append("b");
                b--;
                cb++;
                ca=0;
                cc=0;
            }else if((c>=a && c>=b && cc!=2) || (ca==2 && c>0) || (cb==2 && c>0)){
                sb.append("c");
                c--;
                cc++;
                ca=0;
                cb=0;
            }else{
                break;
            }
        }
        return sb.toString();
    }
}
