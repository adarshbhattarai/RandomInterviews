package com.adarsh;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by adarshbhattarai on 2/9/19.
 */
public class ParmeshworAmazon {

    public static void main(String[] args) {

        // 0 1 0 0 1 1 0 1

        int[] state = new int[]{1,1,1,0,1,1,1,1};

        int n=2;
        while(n>0){
        int prev = 0;
        for(int i=0;i<8;i++){
            int curr= state[i];
            int next = i<7 ? state[i+1] : 0;
            state[i]=prev^next;
            prev=curr;
        }
        n--;
        }

       // Arrays.stream(state).forEach(System.out::println);

        demoLitionRobot();
        System.out.println(min);
    }
    static int min=Integer.MAX_VALUE;
    static  void demoLitionRobot(){

        int[][] a = new int [][]{{1,1,1,1},{0,1,1,1},{0,1,0,1},{1,1,9,1},{0,0,1,1}};
        findMin(a,0,0,0,new HashSet());
    }

    private static void findMin(int[][] a , int x,int y,int curMin,Set<String> visited ){

        if(x<0||x>=a.length||y<0||y>=a[0].length) return;
        if(a[x][y]==0) return;
        if(a[x][y]==9){

            min=Math.min(min,curMin);
            return;
        }
        if(visited.contains(x+"-"+y)) return;
        visited.add(x+"-"+y);
        findMin(a,x,y+1,curMin+1,visited);
        findMin(a,x+1,y,curMin+1,visited);
        findMin(a,x-1,y,curMin+1,visited);
        findMin(a,x,y-1,curMin+1,visited);
        visited.remove(x+"-"+y);

    }


}
