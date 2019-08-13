package com.adarsh;

import java.util.Arrays;

/**
 * @author adarshbhattarai on 2019-08-11
 * @project untitled
 */
public class GargiFacebookInterview {

    public static void main(String[] args) {

        int [] a = {2,3,4,5};

        findProductExceptSelf(a);
    }

    private static void findProductExceptSelf(int[] a) {

        int temp =1;
        int result[] = new int[a.length];

        for(int i=0;i<a.length;i++){
            result[i] = temp;
            temp *= a[i];
        }
        System.out.println(Arrays.toString(result));
        temp=1;
        for(int i = a.length-1; i>=0; i--){

            result[i] *= temp;
            temp = temp * a[i];
        }

        System.out.println(Arrays.toString(result));
    }
}
