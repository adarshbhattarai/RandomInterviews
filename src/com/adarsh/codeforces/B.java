package com.adarsh.codeforces;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author adarshbhattarai on 2020-09-12
 * @project untitled
 */
public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        int[] output = new int[testcases];
        for(int i=0;i<testcases;i++){
            //System.out.println("Provide N");
            int N = sc.nextInt();
            int[] M =  new int[N];
            for(int j=0;j<N;j++){
                M[j] =  Integer.parseInt(sc.next());
            }
            output[i]=solve(M);

        }

        for(int s : output)
            System.out.println(s);
    }

    private static int solve(int[] m) {

        Arrays.sort(m);

        int rMax=Integer.MIN_VALUE;
        rMax=Math.max(p(2,3,m),rMax);
        rMax=Math.max(p(4,1,m),rMax);
        rMax=Math.max(p(0,5,m),rMax);
        rMax=Math.max(p(5,0,m),rMax);
        rMax=Math.max(p(1,4,m),rMax);
        rMax=Math.max(p(3,2,m),rMax);


        return rMax;
    }

    static int  p(int s, int e, int[] m){
        int currMax=1;
        for(int i=0;i<s;i++){
            currMax*=m[i];
        }
        for(int i=0;i<e;i++){
            currMax*=m[m.length-1-i];
        }
        return currMax;
    }

    private static int[] readNextIntArray(Scanner sc, int N) {
        int[] read = new int[N+1];
        for(int i=0;i<N;i++){
            String s = sc.next();
            read[i] = Integer.parseInt(s);
        }
        return read;
    }
}
