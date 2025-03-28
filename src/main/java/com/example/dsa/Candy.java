package com.example.dsa;

import java.util.Arrays;

public class Candy {
    public static void main(String[] args) {
        int[] ratings={1,0,2};
        System.out.println(minNumOfCandies(ratings));
    }
    public static int minNumOfCandies(int[] ratings){
        //Approach we are using will use 2 passes of the array, once from left to right then from right to left
        //In each pass we will check if the child in next index has more rating and keep increasing the candy count accordingly.
        int[] candy=new int[ratings.length];
        Arrays.fill(candy,1);
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                candy[i]=candy[i-1]+1;
            }
        }
        for(int i=ratings.length-1;i>0;i--){
            if(ratings[i]<ratings[i-1] && candy[i]>=candy[i-1]){
                candy[i-1]=candy[i]+1;
            }
        }
        return Arrays.stream(candy).sum();
    }
}
