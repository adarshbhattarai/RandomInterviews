package com.adarsh.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author adarshbhattarai on 2020-07-14
 * @project untitled
 */
public class Patiram2020Amazon {

    //rows=5
    //col=4
    //grid
    //1 1 0 0
    //0 0 1 0
    //0 0 0 0
    //1 0 1 1
    //1 1 1 1

    //output:-3
    public static void main(String[] args) {

        Patiram2020Amazon amazon = new Patiram2020Amazon();
        List input = new ArrayList();
        List row1 = new ArrayList();
        row1.add(1);
        row1.add(1);
        row1.add(0);
        row1.add(0);
        List row2 = new ArrayList();
        row2.add(0);
        row2.add(0);
        row2.add(0);
        row2.add(0);
        List row3 = new ArrayList();
        row3.add(0);
        row3.add(0);
        row3.add(1);
        row3.add(1);
        List row4 = new ArrayList();
        row4.add(0);
        row4.add(0);
        row4.add(0);
        row4.add(0);
        input.add(row1);
        input.add(row2);
        input.add(row3);
        input.add(row4);
        System.out.println(amazon.input(4,4,input));
    }

    public int input(int rows, int col, List<List<Integer>> grid){

        int count=0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<col;j++){
                if(grid.get(i).get(j) == 1){
                    count++;
                    dfs(i,j,grid);
                }
            }
        }

        return count;
    }

    private void dfs(int i, int j, List<List<Integer>> grid) {

        if(isValid(i,j,grid)){
            grid.get(i).set(j,0);
            dfs(i+1,j,grid);
            dfs(i-1,j,grid);
            dfs(i,j+1,grid);
            dfs(i,j-1,grid);
        }
    }

    private boolean isValid(int i, int j, List<List<Integer>> grid) {
        return i>=0 && i<grid.size() && j>=0 && j<grid.get(0).size() && grid.get(i).get(j) == 1;
    }

}
