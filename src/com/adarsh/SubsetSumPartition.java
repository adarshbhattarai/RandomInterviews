package com.adarsh;

import java.util.Arrays;

/**
 * Created by adarshbhattarai on 3/17/19.
 */
public class SubsetSumPartition {

    public static void main(String[] args) {
        System.out.println(ispartitionalable(new int[]{88,29,42,97,15,74,16,52,59,28,86,35,50,99,50,94,46,74,16,94,52,24,90,60,37,68,85,74,96,22,16,50,11,70,39,68,97,11,46,27,44,78,35,26,84,18,93,77,98,47,20,74,100,95,64,75,69,43,16,20,79,30,45,9,69,9,74,98,16,6,13,72,53,61,70,71,58,80,64,21,14,27,1,45,75,28,33,5,45,89,99,54,83,58,96,19,25,15,48}));
        System.out.println(ispartitionalable(new int[]{1,2,5}));
        System.out.println(ispartitionalable(new int[]{2,4,4,6,6,6,6,7,8,8,8,8,10,10,10,12,13,13,13,14,14,15,15}));
    }

    private static boolean ispartitionalable(int[] a) {

        Arrays.sort(a);

        int totalSum=0;

        for(int i=0;i<a.length;i++){
            totalSum+=a[i];
        }

        if(totalSum%2==1)return false;
        totalSum/=2;

        int min= a[0];
        for(int i=a.length-1;i>=0;i--){
            if(totalSum-a[i]>=min||totalSum-a[i]==0 ) totalSum-=a[i];
            if(totalSum==0) return true;
        }
        System.out.println(min+" "+totalSum);
        return false;

    }


}
