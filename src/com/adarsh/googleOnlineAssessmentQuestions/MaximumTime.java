package com.adarsh.googleOnlineAssessmentQuestions;

/**
 * @author adarshbhattarai on 2019-10-27
 * @project untitled
 *
 * You are given a string that represents time in the format hh:mm.
 * Some of the digits are blank (represented by ?). Fill in ? such that the time represented by
 * this string is the maximum possible.
 * Maximum time: 23:59, minimum time: 00:00. You can assume that input string is always valid.
 *
 * Input: "?4:5?"
 * Output: "14:59"
 *
 * Input: "23:5?"
 * Output: "23:59"
 *
 * Input: "2?:22"
 * Output: "23:22"
 *
 * Input: "0?:??"
 * Output: "09:59"
 *
 * Input: "??:??"
 * Output: "23:59"
 */
public class MaximumTime {

    public static void main(String[] args) {

        int[] maxTimes = {2,9,0,5,9};
        String input = "?9:4?";

        if(input.charAt(1)>='4')
            maxTimes[0]= 1;
        else if(input.charAt(0)=='2'){
            maxTimes[1]=3;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<5;i++){

            if(input.charAt(i)=='?')
                stringBuilder.append(maxTimes[i]);
            else
                stringBuilder.append(input.charAt(i));
        }
        System.out.println(stringBuilder.toString());
    }
}
