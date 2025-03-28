package com.example.dsa;

import java.util.Stack;

public class BaseballGame {
    public static void main(String[] args) {
        String[] operations={"5","2","C","D","+"};
        System.out.println(Game(operations));
    }
    public static int Game(String[] operations){
        Stack<Integer> stack=new Stack<>();
        int temp;
        for(String s:operations){
            switch(s){
                case "+":
                    int t=Integer.parseInt(String.valueOf(stack.pop()));
                    temp=t+Integer.parseInt(String.valueOf(stack.peek()));
                    stack.push(t);
                    stack.push(temp);
                    continue;
                case "D":
                    temp=Integer.parseInt(String.valueOf(stack.peek()))*2;
                    stack.push(temp);
                    continue;
                case "C":
                    stack.pop();
                    continue;
                default:
                    stack.push(Integer.parseInt(s));
            }
        }
        int result=0;
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        return result;
    }
}
