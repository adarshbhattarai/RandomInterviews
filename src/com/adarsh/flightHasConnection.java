package com.adarsh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Created by adarshbhattarai on 3/3/19.
 */
public class flightHasConnection {

    public static void main(String [] args){

	/*Map m = new HashMap();

	m.put("Hi","Hello");
	if(m != null && !m.isEmpty()) {
		System.out.println("Satisfies both");
		System.out.println(m.get("Hi"));
	}
	*/
        List<Integer> s =new ArrayList();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        System.out.println(isConnected(1,4, s));

    }
    static boolean  isConnected(int src, int dest, List<Integer> s) {
        // TODO Auto-generated method stub

        //1. Get List Of Connections
        Map<Integer,List<Integer>> m = new HashMap();
        generateConnections(m,s);

        System.out.println("List is --> " + m);
        //2. Search Connections
        searchConnections(m,src,dest);
        System.out.println("src " + src + " ; dest " + dest +" ;map " + m.get(src) );
        return m.get(src).contains(dest);
    }


    private static void searchConnections(Map<Integer, List<Integer>> m, int src, int dest) {
        // TODO Auto-generated method stub

        List<Integer> original = m.get(src);
        List<Integer> visitedList = new ArrayList();
        Set isVisited = new HashSet();
        Stack<Integer> s = new Stack();
        s.add(src);
        while(s.size()>0){
            int currentVal = s.pop();
            if(m.get(currentVal).contains(dest)){
                System.out.println("Found Value "+ currentVal );
                visitedList.add(dest);
                m.put(src, visitedList );
                return;
            }
            List<Integer> l = m.get(currentVal);
            for(int val : l){

                if(!isVisited.contains(val)){
                    visitedList.add(val);
                    System.out.println("Not Visited values " + val);
                    isVisited.add(val);
                    s.push(val);
                }
                else{
                    System.out.println("Already Visited: "+ val + " --> " + m.get(val));
                }
            }
            System.out.println(s);
        }
    }


    private static void generateConnections(Map<Integer, List<Integer>> m, List<Integer> s) {
        // TODO Auto-generated method stub

        for(int a : s){
            for(int j=0;j<s.size();j++){
                if(hasDirectConnection(a,s.get(j))){
                    if(m.containsKey(a)){
                        List l = m.get(a);
                        l.add(s.get(j));
                        m.put(a, l);
                    }else{
                        List l = new ArrayList();
                        l.add(s.get(j));
                        m.put(a, l);
                    }
                }
            }
        }

    }


    static boolean hasDirectConnection(int source, int destination){
        boolean hasConnection=false;
        Map<Integer,List<Integer>> m = new HashMap();
        m.put(1,new ArrayList(Arrays.asList(new Integer[]{3})));
        m.put(2,new ArrayList(Arrays.asList(new Integer[]{4,1})));
        m.put(3,new ArrayList(Arrays.asList(new Integer[]{2})));
        m.put(4,new ArrayList(Arrays.asList(new Integer[]{4})));
        return m.get(source).contains(destination);
    }
}
