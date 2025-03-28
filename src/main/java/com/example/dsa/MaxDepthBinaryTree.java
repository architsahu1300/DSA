package com.example.dsa;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthBinaryTree {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(3,null,null);
        int[] tree={3,9,20, Integer.parseInt(null),Integer.parseInt(null),15,7};
        for(int i=0;i<tree.length;i++){
            Queue<Integer> qu=new LinkedList<>();

        }
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (){};
    TreeNode (int val){
        this.val=val;
    }
    TreeNode (int val,TreeNode left, TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}
