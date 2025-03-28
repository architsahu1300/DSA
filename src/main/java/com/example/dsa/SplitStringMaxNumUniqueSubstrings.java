package com.example.dsa;

import java.util.HashMap;
import java.util.HashSet;

public class SplitStringMaxNumUniqueSubstrings {
    static int maxCount;
    public static void main(String[] args) {
        String s="wwwzfvedwfvhsww";
        System.out.println(maxNumOfSubstrings(s));
    }
    public static int maxNumOfSubstrings(String s){
        //Greedy method won't work in this question because we do not know what is ahead.
        //For ex like "abcaaaa" we won't even get a valid answer. We will need BACKTRACKING for this.
//        HashMap<String,Integer> map=new HashMap();
//        StringBuilder sb=new StringBuilder();
//        for(char c:s.toCharArray()){
//            sb.append(c);
//            if(!map.containsKey(sb.toString())){
//                map.put(sb.toString(),1);
//                sb.setLength(0);
//            }
//        }
//        return map.keySet().size();
        maxCount=0;
        HashSet<String> set=new HashSet<>();
        backtrack(s,set,0);
        return maxCount;
    }
    public static void backtrack(String s, HashSet<String> set, int index){
        if(index==s.length()){
            maxCount=Math.max(maxCount,set.size());
            return;
        }
        for(int i=index;i<s.length();i++){
            String substr=s.substring(index,i);
            if(!set.contains(substr)){
                set.add(substr);
                backtrack(s,set,i+1);
                set.remove(substr);
            }
        }
    }
}
