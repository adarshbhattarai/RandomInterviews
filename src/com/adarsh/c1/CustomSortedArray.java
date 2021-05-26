package com.adarsh.c1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adarshbhattarai on 2021-05-02
 * @project untitled
 */
public class CustomSortedArray {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(8);
        arr.add(5);
        arr.add(11);
        arr.add(4);
        arr.add(6);
        System.out.println(moves(arr));
    }

    public static int moves(List<Integer> arr) {
        // Write your code here
        int fst=0;
        int lst = arr.size()-1;
        int moves=0;
        while(fst<lst){
            int firstNum = arr.get(fst);
            int secondNum = arr.get(lst);

            if(firstNum%2==0){
                fst++;
            }else if(secondNum%2!=0){
                lst--;
            }else{
                fst++;
                lst--;
                moves++;
            }
        }
        return moves;
    }
}