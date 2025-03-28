package com.example.dsa;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr={4,67,3,6,8,23,45,67,2,6,9,44};
        System.out.println(Arrays.toString(arr));
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    public static int partition(int[] arr, int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }
    public static void sort(int[] arr, int low, int high){
        if(low<high){
            int pi=partition(arr,low,high);
            //Sort left and right of pivot element
            sort(arr,low,pi-1);
            sort(arr,pi+1,high);
        }

    }
}
