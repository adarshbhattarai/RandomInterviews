package com.adarsh;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adarshbhattarai on 3/3/19.
 */

/*
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * */
public class Subsets {

    public static void main(String[] args){

        int[] input = {1,2,3};
        List subsets = subsets(input);

        List subsets_Two = subsetsBitApproach(input);

        subsets_Two.stream()
                .forEach(System.out::println);
    }

    /*
     * Intro :
     *
     * for a and b, subsets are {}, {a}, {b} and {a,b}
     * which is equivalent to 0, 01,10, 11
     * for a,b,c; we can represent it as 000, 001,010,011,100,101,110,111
     * this is all we need for subsets. So lets just do the mapping
     * */
    private static List subsetsBitApproach(int[] input) {
        // TODO Auto-generated method stub
        //2^input length, 2 has 4 numbers, 3 has 8 results. so to keep up
        int totalNumber = 1<<input.length;
        List returnList = new ArrayList();
        for(int i=0; i<totalNumber; i++){
            List subset =new ArrayList();
            for(int j=0; j<input.length;j++){
                //lets say i is 4 then j is on 2,
                //then, 1<<2=100 which is 4
                // so 3 is added
                //likewise, for 101 1,3 is added. same process follows.
                if((i & (1<<j)) != 0){
                    subset.add(input[j]);
                }
            }
            returnList.add(subset);
        }

        return returnList;
    }

    private static List subsets(int[] input) {
        // TODO Auto-generated method stub

        List result = new ArrayList();
        backtrack(result,new ArrayList(), input,0);
        return result;
    }

    private static void backtrack(List result, ArrayList temp, int[] input,int val) {
        // TODO Auto-generated method stub
        result.add(new ArrayList(temp));
        for(int i=val; i<input.length;i++){
            temp.add(input[i]);
            backtrack(result, temp, input,i+1);
            temp.remove(temp.size()-1);
        }

    }
}