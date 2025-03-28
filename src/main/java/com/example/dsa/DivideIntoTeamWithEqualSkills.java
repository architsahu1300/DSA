package com.example.dsa;

import java.util.HashMap;
import java.util.Arrays;

public class DivideIntoTeamWithEqualSkills {
    public static void main(String[] args) {
        //int[] skill={3,2,5,1,3,4};
        //int[] skill={2,3,4,2,5,5};
        int[] skill={2,2,2,2};
        System.out.println(dividePlayers(skill));
    }
    public static long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long result = 0;
        int avg = skill[0] + skill[skill.length - 1];
        for (int i = 0; i < skill.length / 2; i++) {
            if (skill[i] + skill[skill.length - 1 - i] != avg) {
                return -1;
            }
            else {
                result += (long) skill[i] * skill[skill.length - 1 - i];
            }
        }
        return result;
    }
}
