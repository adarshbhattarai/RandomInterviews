package leetcode;


import com.sun.tools.javac.util.Assert;

import java.util.Arrays;

/**
 *1300 LC
 * Given an integer array arr and a target value target, return the integer
 * value such that when we change all the integers larger than value in the given array
 * to be equal to value, the sum of the array gets as close as possible (in absolute difference) to target.
 *
 * In case of a tie, return the minimum such integer.
 *
 * Notice that the answer is not neccesarilly a number from arr.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [4,9,3], target = 10
 * Output: 3
 * Explanation: When using 3 arr converts to [3, 3, 3] which sums 9 and that's the optimal answer.
 * Example 2:
 *
 * Input: arr = [2,3,5], target = 10
 * Output: 5
 * Example 3:
 *
 * Input: arr = [60864,25176,27249,21296,20204], target = 56803
 * Output: 11361
 * @author adarshbhattarai on 2020-01-10
 * @project untitled
 */
public class SumOfMutatedArray {

    public static void main(String[] args) {
        SumOfMutatedArray sumOfMutatedArray = new SumOfMutatedArray();

        int actual0 = sumOfMutatedArray.findBestValue(new int[]{1547,83230,57084,93444,70879},71237);

        System.out.println(actual0);

        int actual1 = sumOfMutatedArray.findBestValue(new int[]{4,9,3},10);

        int actual2 = sumOfMutatedArray.findBestValue(new int[]{5,10,15},40);


        int actual3 = sumOfMutatedArray.findBestValue(new int[]{60864,25176,27249,21296,20204},56803);

        int expected1= 3;
        int expected2 = 25;
        int expected3= 11361;

        System.out.println(actual1+" "+actual2+" "+actual3);

        Assert.check(expected1==actual1);
        Assert.check(expected2==actual2);
        Assert.check(expected3==actual3);
    }
    public int findBestValue(int[] arr, int target) {

        Arrays.sort(arr);
        int low=0;
        int possible=(int)Math.round(1.0*target/arr.length);
        while(possible>arr[low]){
            target-=arr[low];
            if(++low==arr.length)break;
            possible=(int)Math.round((1.0*target/(arr.length-low)-.1));
        }

        return possible;
    }
}
