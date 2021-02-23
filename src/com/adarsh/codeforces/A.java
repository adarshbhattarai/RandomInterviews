package com.adarsh.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author adarshbhattarai on 2020-09-12
 * @project untitled
 */
public class A {
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

        int tSum = 0;

        Arrays.sort(m);
        Map<Integer,Integer> set = new HashMap<>();
        for(int i=0;i<m.length;i++){
            set.put(m[i],set.getOrDefault(m[i],0)+1);
        }
        int sum=-1;
        int j=0;
        int rot=0;
        int miss = -1;
        for(;j<m.length&&rot<2;j++){
            if(!set.containsKey(j) && miss==-1){
                return 2*j;
            }
           if(!set.containsKey(j)){
               sum=j;
               break;
           }
           if(set.containsKey(j)&&miss==-1 &&set.get(j)==1){
               miss=j;
           }
        }


        return sum==-1?m.length:sum+miss;


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
