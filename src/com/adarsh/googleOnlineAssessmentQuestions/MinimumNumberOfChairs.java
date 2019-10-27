package com.adarsh.googleOnlineAssessmentQuestions;

import java.util.Arrays;

/**
 * @author adarshbhattarai on 2019-10-27
 * @project untitled
 *
 * There are n guests who are invited to a party. The k-th guest will attend the party at time S[k]
 * and leave the party at time E[k].
 *
 * Given an integer array S and an integer array E, both of length n,
 * return an integer denoting the minimum number of chairs you need such that everyone attending the party can sit down.
 *
 * Input: S = [1, 2, 6, 5, 3], E = [5, 5, 7, 6, 8]
 * Output: 3
 * Explanation:
 * There are five guests attending the party.
 * The 1st guest will arrive at time 1. We need one chair at time 1.
 * The 2nd guest will arrive at time 2. There are now two guests at the party, so we need two chairs at time 2.
 * The 5th guest will arrive at time 3. There are now three guests at the party, so we need three chairs at time 3.
 * The 4th guest will arrive at time 5 and, at the same moment, the 1st and 2nd guests will leave the party.
 * There are now two (the 4th and 5th) guests at the party, so we need two chairs at time 5.
 * The 3rd guest will arrive at time 6, and the 4th guest will leave the party at the same time.
 * There are now two (the 3rd and 5th) guests at the party, so we need two chairs at time 6.
 * So we need at least 3 chairs.
 *
 * https://leetcode.com/problems/meeting-rooms-ii
 */
public class MinimumNumberOfChairs {

    public static void main(String[] args) {
        int[] S = {1, 2, 6, 5, 3};
        int[] E={5, 5, 7, 6, 8};
        int minChairsReqd = findMinChairs(S,E);
        System.out.println(minChairsReqd==3);
    }

    private static int findMinChairs(int[] start, int[] end) {

        int chairs=0;

        Arrays.sort(start);
        Arrays.sort(end);

        int endChair=0;

        for(int i =0; i<start.length;i++){

            if(start[i]<end[endChair]){
                chairs++;
            }else {
                endChair++;
            }

        }
        return  chairs;
    }
}
