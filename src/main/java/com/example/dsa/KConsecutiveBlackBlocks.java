package com.example.dsa;

public class KConsecutiveBlackBlocks {
    public static void main(String[] args) {
        String blocks="WBBWWBBWBW";
        int k=7;
        System.out.println(minOperationsForKBlackBlocksOptimal(blocks,k));
    }
    private static int minOperationsForKBlackBlocksBrute(String blocks, int k) {
        int minimum=Integer.MAX_VALUE;
        for(int i=0;i<blocks.length()-k+1;i++){
            int currLen=0;
            for(int j=i;j<i+k;j++){
                if(blocks.charAt(j)=='W'){
                    currLen++;
                }
            }
            minimum=Math.min(minimum,currLen);
        }
        return minimum;
    }
    private static int minOperationsForKBlackBlocksOptimal(String blocks, int k) {
        int n = blocks.length();
        int black = 0;
        int minRecoloring = Integer.MAX_VALUE;

        for (int i = 0; i < n; ++i) {
            if (blocks.charAt(i) == 'B') {
                black++;
            }
            if (i >= k - 1) {
                minRecoloring = Math.min(k - black, minRecoloring);
                if (blocks.charAt(i - k + 1) == 'B') {
                    black--;
                }
            }
        }
        return minRecoloring;
    }
}
