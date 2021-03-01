package GrokkingSixteenPatterns.SlidingWindow;

/**
 * @author adarshbhattarai on 2021-02-23
 * @project untitled
 *
 *
 * Given an array of characters where each character represents a fruit tree, you are given two baskets,
 * and your goal is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.
 *
 * You can start with any tree, but you can’t skip a tree once you have started.
 * You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
 *
 * Write a function to return the maximum number of fruits in both baskets.
 *
 * Example 1:
 *
 * Input: Fruit=['A', 'B', 'C', 'A', 'C']
 * Output: 3
 * Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
 *
 * Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
 * Output: 5
 * Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
 * This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
 *
 */
public class FruitsIntoBaskets {

    public static void main(String[] args) {

        Character[] fruits = {'A','B','C','B','B','C'};
        Character[] fruits2 = {'A', 'B', 'C', 'A', 'C'};
        System.out.println(findLength(fruits)==5);
        System.out.println(findLength(fruits2)==3);
    }

    private static int findLength(Character[] fruits) {
        int start=0;
        int count=0;
        int[] map = new int[26];
        int basket=0;
        for(int i=0;i<fruits.length;i++){
            if(map[fruits[i]-'A']++==0){
                basket++;
            }
            while (basket>2){
                map[fruits[start]-'A']--;
                if(map[fruits[start]-'A']==0){
                    basket--;
                }
                start++;
            }
            count=Math.max(count,i-start+1);
        }

        return count;
    }
}
