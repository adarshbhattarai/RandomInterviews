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

        r.add(0);
        r.add(9);
        r.add(1);
        lot.add(r);



        int mins = removeObstacles(3,3,lot);
        System.out.println(mins);
        System.out.println(min);
    }

    private  static int removeObstacles(int numRows, int numColumns, List<List<Integer>> lot){


        boolean[][] visited = new boolean[numRows][numColumns];


       // findMin(lot,0,0,0,visited);
        //return min;

        for(int i=0;i<lot.size();i++){
            for(int j=0;j<lot.get(0).size();j++){
                if(lot.get(i).get(j)==0){
                    visited[i][j]= true;
                }
            }
        }

        Queue<Dist> q = new LinkedList();
        Dist d = new Dist(0,0,0);
        q.add(d);

        visited[0][0]=true;

        while(!q.isEmpty()){

            Dist dis = q.poll();
            if(lot.get(dis.row).get(dis.col)==9){
                return dis.dist;
            }

            if(dis.row -1 >=0 &&
            !visited[dis.row-1][dis.col]
            ){

                q.offer(new Dist(dis.row-1,dis.col,dis.dist+1));
                visited[dis.row-1][dis.col] = true;
            }

            if(dis.row +1 < lot.size() &&
                    !visited[dis.row+1][dis.col]
            ){

                q.offer(new Dist(dis.row+1,dis.col,dis.dist+1));
                visited[dis.row+1][dis.col] = true;
            }
            if(dis.col -1 >=0 &&
                    !visited[dis.row][dis.col-1]
            ){

                q.offer(new Dist(dis.row,dis.col-1,dis.dist+1));
                visited[dis.row][dis.col-1] = true;
            }
            if(dis.col +1 < lot.get(0).size() &&
                    !visited[dis.row][dis.col+1]
            ){

                q.offer(new Dist(dis.row,dis.col+1,dis.dist+1));
                visited[dis.row][dis.col+1] = true;
            }

        }
        return -1;
       // return currMin;
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

    static class Dist {
        int row;
        int col;
        int dist;
        Dist(int row,int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

}
