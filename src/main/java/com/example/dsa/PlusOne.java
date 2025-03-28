package com.example.dsa;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits={2,4,8,9};
        int[] result=plusOne(digits);
        System.out.println(result);

    }
    public static int[] plusOne(int[] digits){
        int n=digits.length;
        //If a digit is smaller than 9 then we just add 1 and return the array
        for(int i=n-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            //This means we encountered a 9, so we make that element as 0
            // and in the next iteration of for loop i-1th digit will be automatically incremented by 1 and returned the array
            digits[i]=0;
        }
        //In case we did not yet return the flow in above for loop it means we encountered all 9s
        //Here we create a new array of size +1 and set 1st element as 1 and rest elements are 0 by default hence we just return
        int[] newDigits=new int[n+1];
        newDigits[0]=1;
        return newDigits;
    }
}
