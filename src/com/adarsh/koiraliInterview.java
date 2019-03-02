package com.adarsh;

import java.util.*;

/**
 * Created by adarshbhattarai on 5/28/18.
 */
public class koiraliInterview {


    public  static  void main(String [] args){

        int[][] val = new int[][]{{-1,-2},{1,2},{2,4},{-3,2},{2,-2}};
        koiraliInterview k = new koiraliInterview();
        System.out.println(k.solution(val));

    }

    public int solution(int[][] values){

        Map<Integer,Integer> m = new HashMap<Integer, Integer>();

        for(int[] val : values){

            if(!isInSameLine(val[0],val[1],m)){
                m.put(val[0],val[1]);
            }
        }
        System.out.println(m);
        return m.size();

    }

    List<List<Integer>> ClosestXdestinations(int numDestinations,
                                             List<List<Integer>> allLocations,
                                             int numDeliveries)
    {
        // WRITE YOUR CODE HERE
        Map<Double,List<Integer>> map = new TreeMap<>();

        for(List<Integer> locations : allLocations){
            int x = locations.get(0);
            int y = locations.get(1);
            double sqrt = calculateSquareRoot(x,y);
            map.put(sqrt,locations);
        }
        List<List<Integer>> returnList = new ArrayList();

        for(Map.Entry<Double,List<Integer>> entry :  map.entrySet()){
            if(numDeliveries == 0) break;
            List<Integer> points = entry.getValue();
            returnList.add(points);
            numDeliveries--;
        }

        return returnList;
    }
    public Double calculateSquareRoot(int x, int y){
        return Math.sqrt(x*x + y*y);
    }
    private boolean isInSameLine(int a, int b,Map<Integer,Integer> m) {

        if(m.containsKey(a) && m.get(a)== b) {
            return  true;
        }


        for (Map.Entry<Integer, Integer> entry : m.entrySet())
        {

            int currentKey =  entry.getKey();
            int currentVal = entry.getValue();
            int rem = currentKey / a;
            if (rem * a == currentKey && currentVal == b* rem && rem>0)
                return true;
        }

        return false;
    }
}
