package com.example.dsa;

public class GasStation {
    public static void main(String[] args) {
        int[] gas={1,2,3,4,5,4,1,1,1};
        int[] cost={3,4,5,1,2,1,2,10,8};
        int start=canCompleteCircuit(gas,cost);
        System.out.println(start);
    }
    public static int canCompleteCircuit(int[] gas,int[] cost){
        //https://www.youtube.com/watch?v=3wUa7Lf1Xjk
        //Greedy solution
        //We keep track of negative cost until we find a station where we can move forward to next station because gas-cost>0
        //Post this we keep track of total gas and total cost
        int position=0,tempSum=0,totalCost=0;
        for(int i=0;i<gas.length;i++){
            tempSum+=gas[i]-cost[i];
            if(tempSum<0){
                totalCost+=tempSum;
                tempSum=0;
                position=i+1;
            }
        }
        totalCost+=tempSum;
        return totalCost>=0?position:-1;
    }
}
