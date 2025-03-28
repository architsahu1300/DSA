package com.example.dsa;

import java.util.HashMap;

public class IsomorphicStrings {
    public static void main(String[] args) {
        //Isomorphic strings are such that their characters can be replaced to get the other string.
        //All occurrences must be replaced by preserving the order.
        //Ex: paper-title,egg,add


        //Edge case of badc-kikp
        //Here we need to check s1 -> s2 as well as s2->s1 because above example is not isomorphic.
        //For this we need to check for duplicate values as well in the hashmap
        String s="paper";
        String t="title";
        //We will create mappings like p->t, a->i and use same mapping for further similar occurrences
        //If somewhere the same repeating character is not replaced by its mapping then return false.
        HashMap<Character,Character> hmap=new HashMap<>();


        //Case 1: if key exists (p) then check if charAt(i) for s2 is 't' or not
        //Case 2 (edge case): if key(a) is not present in hashmap, then see if the value which we are going to map to 'a' is already present in hashmap
        // and if value is not present in hashmap then add the entry in hashmap
        for(int i=0;i<s.length();i++){
            if(hmap.containsKey(s.charAt(i))){
                if(t.charAt(i)!=hmap.get(s.charAt(i))){
                    //return false;
                }
            }
            else{
                if(hmap.containsValue(t.charAt(i))){
                    //return false;
                }
                else{
                    hmap.put(s.charAt(i),t.charAt(i));
                }
            }
        }
        //return true;
    }
}
