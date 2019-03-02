package com.adarsh;

import java.util.*;

/**
 * Created by adarshbhattarai on 9/11/18.
 */
public class AbhijeetMicrosoft {

    public static void main(String[] args){

        int a[] = {10,10,2,4,5};

      Set r = findElements(a);
       System.out.println(r);

        //Moores voting algotihm

        //findMaxElements(a);

        //System.out.print(majorityElement(a));;
    }


    private static Set findElements(int[] a) {

        Set l = new HashSet<>();
        //Number of times any int appears
        int appearingTimes = (int) Math.floor(a.length/3);
        HashMap<Integer,Integer> ret = new HashMap();

        /*
        *
        * Loop through the list and in the result set add the value if it appears more than appearingTimes
        * Implemented Map to keep */
        for(int val : a){
            if(ret.containsKey(val)){
                ret.put(val, ret.get(val)+1);
            }
           if(ret.containsKey(val) &&  ret.get(val)>appearingTimes) {
               l.add(val);
           }
           else{
               ret.put(val,1);
           }
        }
        return l;
    }

    public static int majorityElement(int[] nums) {
        int result = 0, count = 0;

        for(int i : nums) {

            if (count == 0) {
                result = i;
                count++;
            } else if (result == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }
}
