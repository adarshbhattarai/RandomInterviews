package com.adarsh;

import java.util.*;

/**
 * Created by adarshbhattarai on 4/27/17.
 */
public class PrithiviInterview {


    public static void main(String[] args){
        int [] a = {2,3,4,1,9,8,3,2};
        int [] b = {4,4,6,7,8};
        int s = findMaxMul3(b);
        System.out.println(s);


    }

    private static int findMaxMul3(int[] a) {


        Arrays.sort(a);
        List<Integer> l = new ArrayList<Integer>();
        Queue<Integer> q0 = new LinkedList<>();
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        int sum = 0;
        for (int b : a) {
            sum += b;
            if (b % 3 == 0) q0.add(b);
            if (b % 3 == 1) q1.add(b);
            if (b % 3 == 2) q2.add(b);

        }

        if (sum % 3 == 1) {
            if (!q1.isEmpty()) q1.poll();
            else {
                if (!q2.isEmpty()) q2.poll();
                else return 0;
                if (!q2.isEmpty()) q2.poll();
                else return 0;

            }
        } else if (sum % 3 == 2) {

            if (!q2.isEmpty())
                q2.poll();
            else {
                if (q1.isEmpty())
                    q1.poll();
                else
                    return 0;

                if (q1.isEmpty())
                    q1.poll();
                else return 0;

            }
        }

        int i=0;
        while (i<q0.size()) l.add(q0.poll());
        i=0;
        while(i<q1.size())l.add(q1.poll());
        i=0;
        while (i<q2.size())l.add(q2.poll());
        i=0;
        int [] retArray = new int[l.size()];

        for(Integer arr: l) retArray[i++]=arr;

        Arrays.sort(retArray);
        String s = "";
        for(int j=retArray.length-1;j>=0;j--) s+=retArray[j];

        return Integer.parseInt(s);
    }
}
/*
954311
94311

*8432211
*
* You have L, a list containing some digits (0 to 9). Write a function answer(L)
* which finds the largest number that can be made from some or all of these digits
* and is divisible by 3. If it is not possible to make such a number, return 0 as the answer.
 * L will contain anywhere from 1 to 9 digits. The same digit may appear multiple times in the list,
 * but each element in the list may only be used once.
Inputs:
    (int list) l = [3, 1, 4, 1]
Output:
    (int) 4311

Inputs:
    (int list) l = [3, 1, 4, 1, 5, 9]
Output:
    (int) 94311
* */