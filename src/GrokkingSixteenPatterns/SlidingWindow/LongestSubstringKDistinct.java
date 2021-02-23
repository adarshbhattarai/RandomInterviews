package GrokkingSixteenPatterns.SlidingWindow;

import java.util.Arrays;

/**
 * @author adarshbhattarai on 2021-02-23
 * @project untitled
 *
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 */
public class LongestSubstringKDistinct {

    public static void main(String[] args) {
        String input = "araaci";
        int K = 2;
        int output=4;

        String input2 = "araaci";
        int K2 = 1;
        int output2=2;

        String input3 = "cbbebi";
        int K3 = 1;
        int output3=2;

        System.out.println(findLength(input,K)==output);
        System.out.println(findLength(input2,K2)==output2);
        System.out.println(findLength(input3,K3)==output3);
    }

    private static int findLength(String input, int K) {
        int[] map = new int[26];
        int max=0;
        int start=0;
        int distinctChars=0;
        for(int i=0;i<input.length();i++){
            char currChar = input.charAt(i);
            if(map[currChar-97] == 0){
                distinctChars++;
            }
            map[currChar-97]++;
            while(distinctChars>K){
                map[input.charAt(start)-97]--;
                if( map[input.charAt(start)-97] ==0){
                    distinctChars--;
                }
                start++;
            }
            max=Math.max(max,i-start+1);


        }
        return max;
    }
}
