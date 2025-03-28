package com.example.dsa;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class ParsingABooleanExpression {
    public static void main(String[] args) {
        String s="&(|(f))";
        System.out.println(parseBooleanExpr(s));
    }
    public static boolean parseBooleanExpr(String expression){
        //Approach is that we will push all characters on stack (except ',') until we find a ')'
        //Once we find ')' we will take all values (f/t) until we find a '(' and add them on a list
        //Then we will get the operator which will always be stored just before '(' according to the question
        //Then process the list values according to the operator and return the final answer
        Stack<Character> stack=new Stack<>();
        int n=expression.length();
        for(int i=0;i<n;i++){
            char c=expression.charAt(i);
            if(c==')'){
                ArrayList<Character> list=new ArrayList<>();
                while(stack.peek()!='('){
                    list.add(stack.pop());
                }
                stack.pop(); //remove '('
                char opr=stack.pop(); // get operator
                char ans=evaluate(list,opr);
                stack.push(ans);
            }
            else{
                if(c!=','){
                    stack.push(c);
                }
            }
        }
        return stack.pop()=='t';

    }
    public static char evaluate(ArrayList<Character> list, char opr){
        if(opr=='&'){
            if(list.contains('f')) {
                return 'f';
            }
            else{
                return 't';
            }
        }
        else if(opr=='|'){
            if(list.contains('t')){
                return 't';
            }
            else{
                return 'f';
            }
        }
        else{
            return list.get(0)=='t'?'f':'t';
        }
    }
}
