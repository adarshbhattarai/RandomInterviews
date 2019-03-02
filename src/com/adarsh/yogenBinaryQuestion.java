package com.adarsh;

import java.util.*;

/**
 * Created by adarshbhattarai on 2/9/19.
 */
public class yogenBinaryQuestion {

    private static int max;

    public static void main(String[] args) {
        Node node = new Node(4);
        node.left = new Node(5);
        node.right = new Node(6);
        node.right.left = new Node(1);
        node.right.right = new Node(6);
        node.left.left = new Node(4);
        node.left.left.left = new Node(5);

        System.out.println(findMinPath(node));
    }

    private static int findMinPath(Node node) {

        if(node==null) return 0;

        Map m = new HashMap();
         return findMaxPath(node,m);
    }

    private static int findMaxPath(Node node, Map<Integer,Integer> m) {
        if(node==null) return m.size();
        if(m.containsKey(node.value)){
            m.put(node.value,m.get(node.value)+1);
        }else
            m.put(node.value,1);
        int max = Math.max(findMaxPath(node.left,m),findMaxPath(node.right,m));
            m.put(node.value,m.get(node.value)-1);
        if(m.get(node.value) == 0) m.remove(node.value);
        return max;
    }



}
