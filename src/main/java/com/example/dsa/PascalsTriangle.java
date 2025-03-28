package com.example.dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        int numRows=5;
        System.out.println(answer(numRows));
    }
    public static List<List<Integer>> answer(int numRows){
        List<List<Integer>> result=new ArrayList<>();
        if(numRows==0) return result;
        List<Integer> first_row=new ArrayList<>();
        //first row will be 1
        first_row.add(1);
        result.add(first_row);
        for(int i=1;i<numRows;i++){
            //We know the first and last element of every row will be 1
            //Because we want to get prev row we need atleast one row prior
            List<Integer> prev=result.get(i-1);
            List<Integer> curr=new ArrayList<>();
            //1st element will be 1
            curr.add(1);
            for(int j=1;j<i;j++){
                //Sum prev rows elements to get curr element for curr row
                curr.add(prev.get(j-1)+prev.get(j));
            }
            //Last element of row will be 1
            curr.add(1);
            result.add(curr);
        }
        return result;
    }
}
