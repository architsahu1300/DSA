package com.example.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveSubfolders {
    public static void main(String[] args) {
//        String[] folder={"/a/b","/c/d","/c/d/e","/a","/c/f"};
        String[] folder={"/a/b/c","/a/b/ca","/a/b/d"};
        System.out.println(remove(folder));
    }
    public static List<String> remove(String[] folder){
        Arrays.sort(folder);
        List<String> output=new ArrayList<>();
        output.add(folder[0]);
        String newFolder=folder[0]+"/";
        for(int i=1;i<folder.length;i++){
            if(!folder[i].startsWith(newFolder)){
                output.add(folder[i]);
                newFolder=folder[i]+"/";
            }
        }

        return output;
    }
}
