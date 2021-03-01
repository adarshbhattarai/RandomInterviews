package GrokkingSixteenPatterns.SlidingWindow;

/**
 * @author adarshbhattarai on 2021-02-23
 * @project untitled
 *
 * **hard**
 * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter,
 * find the length of the longest substring having the same letters after replacement.
 *
 * Example 1:
 *
 * Input: String="aabccbb", k=2
 * Output: 5
 * Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
 * Example 2:
 *
 * Input: String="abbcb", k=1
 * Output: 4
 * Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
 * Example 3:
 *
 * Input: String="abccde", k=1
 * Output: 3
 * Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
 */
public class LongestSubstringWithReplacement {

    private static int findLength(String input, int K) {
        int[] map = new int[26];
        int max=0;
        int st=0;
        int replacingChar=0;
        int maxRepeating=0;
        for(int i=0;i<input.length();i++){
            map[input.charAt(i)-97]++;
            maxRepeating=Math.max(maxRepeating,map[input.charAt(i)-97]);
            replacingChar = i-st+1-maxRepeating;
            while(replacingChar>K ){
                map[input.charAt(st++)-97]--;
                replacingChar = i-st+1-maxRepeating;
            }
            max=Math.max(max, i-st+1);
        }

        System.out.println(max);
        return max;
    }


    public static void main(String[] args) {
        String input = "aabccbb";
        int K = 2;
        int output=5;

        String input2 = "abbcb";
        int K2 = 1;
        int output2=4;

        String input3 = "abccde";
        int K3 = 1;
        int output3=3;

        String input4 = "abccc";
        int K4 = 1;
        int output4=4;

        System.out.println(findLength(input,K)==output);
        System.out.println(findLength(input2,K2)==output2);
        System.out.println(findLength(input3,K3)==output3);
        System.out.println(findLength(input4,K4)==output4);
    }


}
