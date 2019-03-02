package com.adarsh;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by adarshbhattarai on 2/10/19.
 */
public class AmazonInterviewAbhijeetFriend {

    public static void main(String[] args) {

        List forGround = new ArrayList();
        forGround.add(new int[]{1,2});
        forGround.add(new int[]{2,4});
        forGround.add(new int[]{3,6});

        List sec = new ArrayList();
        sec.add(new int[]{1,2});


        List<Integer[]> l =solveProblem(7,forGround,sec );

        for(int i=0;i<l.size();i++){
            System.out.println(l.get(i)[0]+" " + l.get(i)[1]);
        }
    }

    private static List solveProblem(int noOfDeliveries, List<List<Integer>> forground, List<List<Integer>> bckground) {

        List<Integer[]> l = new ArrayList();
        PriorityQueue<Points> pq = new PriorityQueue<Points>((a,b)->(b.sum-a.sum));

        for(List first: forground){

            for(List second : bckground){

                Points points = new Points((int)first.get(0),(int)second.get(0),(int)first.get(1)+(int)second.get(1));
                pq.add(points);
            }
        }

        while(!pq.isEmpty()){

           // System.out.println(pq.peek().sum+" "+pq.peek().f + " " + pq.peek().b);
            if(pq.peek().sum>noOfDeliveries){
                pq.poll();
            }
            else if(pq.peek().sum==noOfDeliveries){
                l.add(new Integer[]{pq.peek().f,pq.peek().b});
                pq.poll();
            }
            else if(l.size()>0) break;
            else{
                l.add(new Integer[]{pq.peek().f,pq.peek().b});
            }


        }
        return l;
    }

}
class Points{

    int f;
    int b;
    int sum;

    Points(int f, int b, int sum){
        this.f=f;
        this.b=b;
        this.sum=sum;
    }
}
