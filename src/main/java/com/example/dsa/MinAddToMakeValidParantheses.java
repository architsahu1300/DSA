package com.example.dsa;

import java.util.Stack;

public class MinAddToMakeValidParantheses {
    public static void main(String[] args) {
        String s="())}}[}";
        System.out.println(minAddToValidParantheses(s));
    }
    public static int minAddToValidParantheses(String s){
        int result=0;
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
            else if(stack.isEmpty() || stack.peek()!=c){
                result++;
            }
            else if(stack.isEmpty() || stack.peek()==c){
                stack.pop();
            }
        }
        result += stack.size();

        return result;
    }
    public static int LeetcodeQuestion(String s){
        int open=0;
        int close=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                open++;
            }
            else{
                if(open>0){
                    open--;
                }
                else{
                    close++;
                }
            }
        }
        return open+close;
    }
}
