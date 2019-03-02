package com.adarsh;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adarshbhattarai on 5/1/18.
 */
public class Solution {

    public static void main(String[] args){

        int [] a = new int[]{1,2,3,4,5};
        int sum = 6;

        System.out.println(solve(a));

        //5,1
        //3,2,1
        //4,1
        System.out.println(longestSubsequence(a,sum));

    }

    private static List longestSubsequence(int[] a, int sum) {

        List l = new ArrayList();

        return  l;
    }

    private static int solve(int[] a) {

        int currentMax = 0;
        int prevMax = 0;

        for(int b: a){
            if(b<0){
                if(prevMax<currentMax){
                    prevMax=currentMax;
                }
            }
            if(currentMax <= 0) currentMax = 0;

            currentMax +=b;
        }
        return  Math.max(prevMax,currentMax);
    }

}
