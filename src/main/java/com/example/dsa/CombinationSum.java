package com.example.dsa;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        //Aim is to return all combination of numbers who can be summed up to the target number
        int[] candidates={2,3,6,7};
        int target=7;
        //here output is [[2,2,3],[7]] as these combinations sum up to the target(7)
        System.out.println(combinationSum(candidates,target));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        //we will move via the pick/not pick procedure
        //indices and their picks: 0(pick,pick), 1(pick), 2(not pick), 3(not pick) this gives combination 2,2,3. Similarly for other combination
        //Create a function as such (index,target,Data Structure)
        //Recursion tree:
        //                                              f(0,7,[])
        //                          f(0,5,[2])                              f(1,7,[])
        //              f(0,3,[2,2])            f(1,5,[2])
        //      f(0,1,[2,2,2])  f(1,0,[2,2,3])
        //and so on. We will not pick if target at any call is less than the index value.
        //By doing this if index has reached the end and the target==0, then we return the Data Structure.
        //TC will be (2^t)*k (each combination will be repeated k(target) times
        List<List<Integer>> ans=new ArrayList<>();
        //We are passing ans to store the final answer and initially an empty ArrayList is being passed to store temp ds result
        findCombinations(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
    public static void findCombinations(int index,int[] candidates,int target,List<List<Integer>> ans,List<Integer> ds){
        //Base condition: if reached end and target is 0 then add current ds to final answer
        if(index== candidates.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        //Pick the current index only if target is still greater than the current index value
        if(candidates[index]<=target){
            //First we pick the current index hence add in ds and reduce from target for next recursion
            ds.add(candidates[index]);
            findCombinations(index,candidates,target-candidates[index],ans,ds);
            //Removing the latest added element
            ds.remove(ds.size()-1);
        }
        //We removed current index from ds after picking it up if target was greater still, then we move to not pick part
        //Here we are not reducing the target as it is not pick and ds also removed (if it was added)
        findCombinations(index+1,candidates,target,ans,ds);
    }
}
