package com.example.dsa;

public class ArrayProductExceptSelf {
    public static void main(String[] args) {
          int[] nums={-1,-1,0,3,3};
//        int[] answer=new int[nums.length];
//        for(int a:nums){
//            if(a!=0) continue;
//            return answer;
//        }
//        int product=1;
//        boolean hasZero=false;
//        for(int a:nums){
//            if(a!=0){
//                product=product*a;
//            }
//            if(a==0) hasZero=true;
//        }
//        for(int i=0;i<nums.length;i++){
//            if(nums[i]==0){
//                answer[i]=product;
//            }
//            else if(hasZero && nums[i]!=0){
//                answer[i]=0;
//            }
//            else{
//                answer[i]=product/nums[i];
//            }
//        }
//        return answer;
        int N=nums.length;

        //To save space we can use final_array to keep left products.
        //Then take a variable and keep the product of current element and elements to its right by continuous multiplication
        //int[] left_products=new int[N];
        //int[] right_products=new int[N];
        int[] final_array=new int[N];
        //left_products[0]=1;
        //right_products[N-1]=1;
        for(int i=1;i<N;i++){
            final_array[i]=nums[i-1]*final_array[i-1];
        }
        int R=1;
        for(int i=N-1;i>=0;i--){
            final_array[i]=final_array[i]*R;
            R=R*nums[i];
        }
//        for(int i=0;i<N;i++){
//            final_array[i]=left_products[i]*right_products[i];
//        }
        //return final_array;
    }
}
