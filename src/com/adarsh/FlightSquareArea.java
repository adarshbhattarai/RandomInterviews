package com.adarsh;

/**
 * Created by adarshbhattarai on 12/20/18.
 */
public class FlightSquareArea {



    /*
    *
    * Med dp lc-221
        Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

        Example:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0


        Output: 4
*/
    public static void main(String[] args) {

       // int [][] array = {{1,1,1},{1,1,1},{1,1,1}};
        int[][] array = {{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
        System.out.println(largestArea(array));
    }

    private static int largestArea(int[][] array) {

       int dp[][] = new int[array.length][array[0].length];

       int currentMax = 0;
       dp[0][0]= array[0][0];
       for(int i=1;i<dp[0].length;i++){

           dp[0][i] = Math.max(array[0][i],dp[0][i-1]);

       }

        for(int i=1;i<dp.length;i++){
            dp[i][0] = Math.max(array[i][0],dp[i-1][0]);

        }

       for(int i=1;i<dp.length;i++){
           for(int j=1;j<dp[0].length;j++){
               int threeMin = Math.min(array[i-1][j-1],Math.min(array[i-1][j],array[i][j-1]));
               int dpMin =   Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
               if(threeMin == 0 || array[i][j]==0){
                   dp[i][j] = dpMin;
               }else{
                   dp[i][j] = dpMin+1;
               }
               currentMax=Math.max(currentMax,dp[i][j]);
           }
       }

       for(int i[] : dp){
           for(int a :i){
               System.out.print(a+" ");
           }
           System.out.println("");
       }
       return currentMax* 2;
    }
}
