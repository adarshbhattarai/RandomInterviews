package com.adarsh.amazon;

import java.util.*;

/**
 * @author adarshbhattarai on 2021-04-01
 * @project untitled
 * 5 3 2 4 1 2
 * HackerRank Interview
 */
public class Patiran2021OA1 {

    public static void main(String[] args) {


        System.out.println(minimalHeaviestSetA(Arrays.asList(new Integer[]{5, 3, 2, 4, 1, 2})));
    }

    public static List<Integer> minimalHeaviestSetA(List<Integer> arr){

        List<Integer> ret = new ArrayList<>();
        Collections.sort(arr);
        int i=0,j=arr.size()-1;
        int currentLSum=0, currentRSum=0;
        while(i<=j){
            if(currentLSum+arr.get(i)<currentRSum){
                currentLSum+=arr.get(i++);
            }else{

                    currentRSum+=arr.get(j);
                    ret.add(arr.get(j));
                    j--;
            }

        }
        Collections.reverse(ret);
        return  ret;
    }
}

//1 5 4 5 2 7
//12
//3