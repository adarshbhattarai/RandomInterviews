package com.adarsh;

import java.util.*;

/**
 * Created by adarshbhattarai on 2/9/19.
 */
public class ParmeshworAmazon {



    static int min=Integer.MAX_VALUE;
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
        int[][] a = new int [][]{{1,0,0},{1,0,0},{1,9,1}};
        List<List<Integer>>  lot = new ArrayList<>();
        List<Integer> r = new ArrayList<>();
        r.add(1);
        r.add(0);
        r.add(0);
        lot.add(r);

        r = new ArrayList<>();

        r.add(1);
        r.add(0);
        r.add(0);
        lot.add(r);

        r = new ArrayList<>();

        r.add(1);
        r.add(9);
        r.add(1);
        lot.add(r);



        removeObstacles(3,3,lot);
        System.out.println(min);
    }

    private  static int removeObstacles(int numRows, int numColumns, List<List<Integer>> lot){


        boolean[][] visited = new boolean[numRows][numColumns];


       // findMin(lot,0,0,0,visited);
        //return min;

        Queue<Integer[]> q = new LinkedList();
        q.add(new Integer[]{0,0});

        int currMin = 0;
        while(!q.isEmpty()){

            Integer[] out  =  q.poll();

            int a = out[0];
            int b=out[1];

            if(a<0||a>=lot.size()||b<0||b>=lot.get(0).size()) {
                break;
            }
            if(lot.get(a).get(b)==0){
                continue;
            }
            if(lot.get(a).get(b)==9){
                return min;
            }
            q.add(new Integer[]{a+1,b});
            q.add(new Integer[]{a,b+1});
            q.add(new Integer[]{a-1,b});
            q.add(new Integer[]{a,b-1});
            currMin++;

        }

        return currMin+1;
    }
    private static void findMin(List<List<Integer>> a , int x,int y,int curMin,boolean[][] visited ){

        if(x<0||x>=a.size()||y<0||y>=a.get(0).size()) return;
        if(a.get(x).get(y)==0) return;
        if(a.get(x).get(y)==9){

            min=Math.min(min,curMin);
            return;
        }

        if(visited[x][y]) return;
        visited[x][y] = true;
        findMin(a,x,y+1,curMin+1,visited);
        findMin(a,x+1,y,curMin+1,visited);
        findMin(a,x-1,y,curMin+1,visited);
        findMin(a,x,y-1,curMin+1,visited);
        visited[x][y] = false;

    }


}
