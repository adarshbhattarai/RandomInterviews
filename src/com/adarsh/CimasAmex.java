package com.adarsh;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author adarshbhattarai on 2019-08-22
 * @project untitled
 */
public class CimasAmex {

    public static void main(String[] args) {

        //NUmber of balloons that can be formed.
       // a.fun();

        int numberOfBallons =  findBallons("onlablabloon");
        System.out.println(numberOfBallons);

        //2.abc no triplet of any characters

        String findStr = new CimasAmex().combinationWithoutTriplet(1,3,1);
        System.out.println(findStr);
    }

    private  String combinationWithoutTriplet(int a, int b, int c) {

        Queue<Comb> q = new PriorityQueue<Comb>((x,y)->y.v -x.v);

        q.add(new Comb("a",a));
        q.add(new Comb("b",b));
        q.add(new Comb("c",c));

        StringBuilder sb = new StringBuilder();
        String prev="",prevP = "";
        while(!q.isEmpty()){
            if(q.peek().v < 1){
                return sb.toString();
            }
            Comb com = q.poll();
            if(prev.equals(com.s) && prevP.equals(com.s)){
                if(q.isEmpty() || q.peek().v < 1){
                    return  sb.toString();
                }
                Comb next = q.peek();
                sb.append(next.s);
                next.v = next.v -1;
                prevP = prev;
                prev = next.s;
                q.add(next);

            }else{
            sb.append(com.s);
            com.v = com.v -1;
            prevP = prev;
            prev = com.s;
            }
            q.add(com);

        }

        return sb.toString();
    }

    private static int findBallons(String ballonballonAJNJKNSDadasdbol) {

        HashMap<Character,Integer> m = new HashMap();
        for(Character c : ballonballonAJNJKNSDadasdbol.toCharArray()){

            m.put(c,m.getOrDefault(c,0)+1);
        }

        String requiredChars = "balloon";

        int count=0;
        while(true){
            for(char c: requiredChars.toCharArray()){
                if(m.get(c)==null || m.get(c)==0){
                    return count;
                }

                m.put(c,m.get(c)-1);
            }
            count++;
        }

    }

    class Comb{
        String s;
        int v;
        Comb(String s, int v){
            this.s =s ;
            this.v =v;
        }

    }

   /* CimasAmex ax;
    void fun(){

        CimasAmex a = new CimasAmex();
        CimasAmex b = new CimasAmex();
        a.ax = b;
        b.ax =a;

        a.hello();
    }

    private void hello() {
        System.out.println("hello");
    }*/

}
