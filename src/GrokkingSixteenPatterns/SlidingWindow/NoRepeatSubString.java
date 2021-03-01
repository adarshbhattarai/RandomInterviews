package GrokkingSixteenPatterns.SlidingWindow;

import java.util.Arrays;

/**
 * @author adarshbhattarai on 2021-02-23
 * @project untitled
 *
 * Given a string, find the length of the longest substring, which has no repeating characters.
 *
 * Input: String="aabccbb"
 * Output: 3
 * Explanation: The longest substring without any repeating characters is "abc".
 * Example 2:
 *
 * Input: String="abbbb"
 * Output: 2
 * Explanation: The longest substring without any repeating characters is "ab".
 * Example 3:
 *
 * Input: String="abccde"
 * Output: 3
 * Explanation: Longest substrings without any repeating characters are "abc" & "cde".
 *
 */
public class NoRepeatSubString {

    public static void main(String[] args) {

        System.out.println(findLength("aabccbb")==3);

        System.out.println(findLength("abbbb")==2);
        System.out.println(findLength("abccde")==3);
        System.out.println(findLength("abvcdapq")==7);
    }

    private static int findLength(String input) {
        int count=0;
        int[] map = new int[26];
        Arrays.fill(map,-1);
        int start=0;
        for(int i=0;i<input.length();i++){
            if(map[input.charAt(i)-97]>-1){
                start=Math.max(start,map[input.charAt(i)-97]+1);
            }
            count=Math.max(count,i-start+1);
            map[input.charAt(i)-97]=i;
        }
        return count;
    }
}
