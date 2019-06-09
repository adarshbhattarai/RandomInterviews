package com.adarsh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by adarshbhattarai on 5/12/19.
 */
public class AbhijeetAmazon {

    public static void main(String[] args) {

        List<Integer> files = new ArrayList<>();
        files.add(8);
        files.add(4);
        files.add(6);
        files.add(12);
        int numOfSubFiles =2;
        int sum = minimumTime(numOfSubFiles,files);
        System.out.println(sum);
    }

    private static int minimumTime(int numOfSubFiles, List<Integer> files) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(Integer i : files){
            pq.add(i);
        }

        int count = 0;

        while (pq.size()>1){
            int minsSum = pq.poll() + ((!pq.isEmpty()) ? pq.poll() : 0);
            count += minsSum;
            pq.add(minsSum);
        }
        return count;
    }


}
