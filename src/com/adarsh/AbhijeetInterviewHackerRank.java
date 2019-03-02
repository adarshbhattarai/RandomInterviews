package com.adarsh;

import java.util.*;

/**
 * Created by adarshbhattarai on 11/20/18.
 */
public class AbhijeetInterviewHackerRank {

    public static void main(String[] args) {

       AbhijeetInterviewHackerRank a = new AbhijeetInterviewHackerRank();
        System.out.println(a.checkDifference("abc","bba"));
    }

   /* public static List<Integer> getMinimalDiff(List<Integer> a, List<Integer> b){

    }
*/
    int checkDifference(String a , String b) {
        if (a.length() != b.length()) return -1;
       // if(isAnagram(a,b)) return 0;
        return  updatesRequiredToMakeAnagram(a,b);
    }

    private int updatesRequiredToMakeAnagram(String a, String b) {
        int charArr[] = new int[26];

        int count=0;
        for(char c : a.toCharArray()) charArr[c-97]++;
        for(char c : b.toCharArray())
            count += --charArr[c-97]<0 ? 1 : 0;

        return count;
    }

}
