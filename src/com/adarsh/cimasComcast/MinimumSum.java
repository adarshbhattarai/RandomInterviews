package com.adarsh.cimasComcast;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author adarshbhattarai on 2019-12-17
 * @project untitled
 */
public class MinimumSum {

    public static void main(String[] args) {

        List<Integer> arr = Arrays.asList(new Integer[]{10,20,7});
        minSum(arr,4);

    }

    public static int minSum(List<Integer> num, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(Integer n : num){
            pq.add(n);
        }
        while(k>0){

            System.out.println(pq);
            int picked = pq.poll();
            picked = (int)Math.ceil(picked/2.0);
            pq.add(picked);
            k--;
        }
        int count=0;
        while(!pq.isEmpty()){
            count+=pq.poll();
        }
        System.out.println(count);


        return count;
    }
}
