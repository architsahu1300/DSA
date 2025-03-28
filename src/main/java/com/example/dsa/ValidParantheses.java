package com.example.dsa;

import java.util.Stack;

public class ValidParantheses {
    public static void main(String[] args) {
        String s="([}}])";
        System.out.println(isValid(s));

    }
    public static boolean isValid(String s){
        if(s.length()%2!=0) return false;
        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='('){
                stack.push(')');
            }
            else if(c=='{'){
                stack.push('}');
            }
            else if(c=='['){
                stack.push(']');
            }
            else if(stack.isEmpty() || stack.pop()!=c){
                return false;
            }
        }
        return stack.isEmpty();

    }
}
