package com.adarsh;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public final static void main(String[] args) {


        // stripHtmlTags(“<h1>Hello World!</h1> <p>something</p>”)==”Hello World! something”;

        double d = 10.0/-0;
        if(d==Double.POSITIVE_INFINITY){
            System.out.println("Positive");
        }
        else{
            System.out.println("Negative");
        }
        Main main = new Main();

        int[] input = new int[] { 2,4,6,7,8,3,10,-4,-2,-1};
       // int k=2;

        /*while (true){
            int k = (int) (Math.random()*10);;
            int kthComplimentary = kthComp(input,k);
            System.out.println(kthComplimentary +" --> " +  bruteKth(input,k));

            if(kthComplimentary != bruteKth(input,k)) break;
        }*/

        String s = "dasad";
       // isPalindrom(s);


            int a = (int)(Math.random()*100);
            System.out.print(a + " --> " );
        nthFiboncchi(5);
        System.out.print(" --> ");
        nthFiboncchi2(5);
            System.out.println();



    }

    private static void nthFiboncchi(int i) {

        int[] a = new int[i+1];

        if(i==0) System.out.println(0);
        if(i==1) System.out.println(1);
        if(i<2) return;
        a[0]=0;
        a[1]=1;
        for(int j=2;j<=i;j++){
            a[j]= a[j-1] + a[j-2];
          //  System.out.print(a[j] +" ");
        }
        System.out.print(a[i]);
    }

    private static void nthFiboncchi2(int i) {

       int a=1,b=1;

       while(i-2>0){
           int temp =a;
           a=b;
           b+=temp;
           i--;
       }

        System.out.print(b);
    }

    private static void isPalindrom(String s) {

        boolean success=true;
        s=s.toLowerCase();
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)) success=false;
        }
        System.out.println(success);
    }

    private static int kthComp(int[] input, int k) {

        Set s = new HashSet();

        int count =0;
        for(int i: input){
            if(s.contains(k-i)) count++;
            s.add(i);
        }
        return count;
    }

    private static int bruteKth(int[] input, int k){
        int count = 0;
        for(int i=0; i<input.length;i++){
            for(int j=i+1; j<input.length;j++){
                if(input[i]+input[j] == k) count++;
            }
        }
        return count;
    }


}
