package GrokkingSixteenPatterns.SlidingWindow;

import com.sun.tools.javac.util.Assert;

/**
 * @author adarshbhattarai on 2021-02-23
 * @project untitled
 */
public class SubArraySumOfSizeK {

    public static void main(String[] args) {

        int[] input = new int[]{2, 1, 5, 1, 3, 2};
        int K = 3;
        int output=9;

        int[] input2 = new int[]{2, 3, 4, 1, 5};
        int K2 = 2;
        int output2=7;

        System.out.println(subArraySum(input,K) +" " + (subArraySum(input,K)==output));
        System.out.println(subArraySum(input2,K2) +" " + (subArraySum(input2,K2)==output2));

    }

    private static int subArraySum(int[] input, int k) {
        int count=0;

        int start=0;
        int sum=0;
        for(int i=0;i<input.length;i++){
            sum+=input[i];
            if(i-start+1==k){
                count=Math.max(count,sum);
                sum-=input[start];
                start++;
            }

        }
        return count;
    }


}
