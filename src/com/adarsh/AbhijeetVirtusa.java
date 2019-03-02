package com.adarsh;

import java.util.*;

/**
 * Created by adarshbhattarai on 9/12/18.
 */

public class AbhijeetVirtusa {

    public static void main(String[] args) {
        /*try{
            doStuff(args);
        }catch(Exception e){
            System.out.println("exc");
        }
        doStuff(args);*//*
        String[] cities = {"Bang","Pun","San Fram","New York"};
        MySort as = new MySort();
        Arrays.sort(cities,as);
        System.out.println(Arrays.binarySearch(cities,"New York"));*/
       /* Properties p = System.getProperties();
        p.setProperty("pitate","scru");
        String s = p.getProperty("argProp") + " ";
        s += p.getProperty("pitate");
        System.out.println(s);*/

       int [] a = {1,3,46,1,3,9};
       int target = 47;
       int val = distinctPair(a,target);
       System.out.print(val);
    }

    private static int distinctPair(int[] a, long target) {
        Map m = new HashMap();
        Set s = new HashSet();

        for(int i : a){
            System.out.println(target-i);
            if(s.contains(target-i)){
                m.put(Math.min(i,target-i),Math.max(i,target-i));
            }
            s.add(i);

        }

        return  m.size();
    }

  /*  static class MySort implements Comparator{

        @Override
        public int compare(Object o1, Object o2) {
            return (String)o1.compareTo((String)o2);
        }
    }*/

    private static int doStuff(String[] args) {
        return Integer.parseInt(args[0]);
    }
}

