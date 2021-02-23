package GrokkingSixteenPatterns.SlidingWindow;

/**
 * @author adarshbhattarai on 2021-02-23
 * @project untitled
 *
 * Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest
 * contiguous subarray whose sum is greater than or equal to ‘S’.
 * Return 0 if no such subarray exists.
 *
 */
public class SmallestSubArrayWithGivenSum {

    public static void main(String[] args) {

        int[] input = new int[]{2, 1, 5, 2, 3, 2};
        int K = 7;
        int output=2;

        int[] input2 = new int[]{2, 1, 5, 2, 8};
        int K2 = 7;
        int output2=1;

        int[] input3 = new int[]{3, 4, 1, 1, 6};
        int K3 = 8;
        int output3=3;

        System.out.println(findMinSubArray(input,K)==output);
        System.out.println(findMinSubArray(input2,K2)==output2);
        System.out.println(findMinSubArray(input3,K3)==output3);

    }

    private static int findMinSubArray(int[] nums, int target) {
        int count=Integer.MAX_VALUE;
        int start=0;
        int currSum=0;
        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];
            while(currSum>=target){
                count=Math.min(count, i+1-start);
                currSum-=nums[start++];
            }
        }
        return count==Integer.MAX_VALUE?0:count;
    }
}
