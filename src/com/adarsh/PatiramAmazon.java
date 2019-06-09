package com.adarsh;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * Created by adarshbhattarai on 5/28/19.
 */
public class PatiramAmazon {

    public static void main(String[] args) {

        List<String> s = new ArrayList<>();

        s.add("yxc 82 01");
        s.add("eo first qpx");
        s.add("09z cat hamster");
        s.add("06f 12 25 6");
        s.add("az0 first qpx");
        s.add("236 cat dog rabbit snake");


        List returnString = prioritize(s);
        System.out.println(returnString);
    }

    private static List prioritize(List<String> s) {

        List returnList = new ArrayList();
        List newOrder = new ArrayList();

        PriorityQueue<String> queue  = new PriorityQueue<String>(
                (a,b)->{

                    String[] aSplit = a.split(" ");
                    String[] bSplit = b.split(" ");

                    StringBuilder firstStr = new StringBuilder();
                    for(int i=1;i<aSplit.length;i++){
                        firstStr.append(aSplit[i]);
                    }
                    StringBuilder secondStr = new StringBuilder();
                    for(int i=1;i<bSplit.length;i++){
                        secondStr.append(bSplit[i]);
                    }

                    if(firstStr.toString().compareTo(secondStr.toString()) ==0){
                        return aSplit[0].compareTo(bSplit[0]);
                    }

                    return firstStr.toString().compareTo(secondStr.toString());
                }
        );

        for(String str : s ){
            String secondVal = str.split(" ")[1];

            if(isNumber(secondVal)){
                newOrder.add(str);
            }
            else{
                queue.offer(str);
            }
        }

        while(!queue.isEmpty()){
            returnList.add(queue.poll());
        }
        returnList.addAll(newOrder);

        return returnList;
    }

    private static boolean isNumber(String s) {
        boolean isNumber = true;

        try {
            Integer.parseInt(s);
            System.out.println("isNumber " + s);
        }catch (Exception e){
            isNumber = false;
        }
        return isNumber;

    }


}
