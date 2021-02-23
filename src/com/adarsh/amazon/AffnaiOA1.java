package com.adarsh.amazon;

import java.util.*;

/**
 * @author adarshbhattarai on 2020-08-31
 * @project untitled
 */
public class AffnaiOA1 {

    public static void main(String[] args) {
        AffnaiOA1 oa1 = new AffnaiOA1();
        String words = "";
    }
    List<String> retrieveMostFrequentlyUsedWords(String helpText,
                                                 List<String> wordsToExclude)
    {
        List<String> returnResult = new ArrayList();
        if(helpText==null || helpText.trim().equalsIgnoreCase("")){
            return returnResult;
        }
        // WRITE YOUR CODE HERE

        String[] words = helpText.replaceAll("\\W+"," ").toLowerCase().split("\\s+");
        Set<String> exclusions = new HashSet();
        for(String exclude : wordsToExclude){
            exclusions.add(exclude);
        }

        Map<String,Integer> wordAndCount = new HashMap();
        for(String word : words){
            if(!exclusions.contains(word)){
                wordAndCount.put(word, wordAndCount.getOrDefault(word,0)+1);
            }
        }


        Map<Integer,List<String>> invertedCountWord = new HashMap();
        int maxValue=0;
        for(String key : wordAndCount.keySet()){
            int currValue =  wordAndCount.get(maxValue);
            maxValue=Math.max(maxValue,currValue);
            if(!invertedCountWord.containsKey(currValue)){
                invertedCountWord.put(currValue, new ArrayList());
            }
            invertedCountWord.get(currValue).add(key);
        }

        return invertedCountWord.get(maxValue);
//
//        //Descending ordering
//        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<Map.Entry<String,Integer>>(
//                (a,b)->b.getValue() -  a.getValue());
//        for(Map.Entry<String,Integer> entry: wordAndCount.entrySet()){
//            pq.add(entry);
//        }
//
//
//        if(pq.isEmpty()){
//            return returnResult;
//        }
//        // System.out.println(pq);
//        int max = pq.peek().getValue();
//        while(!pq.isEmpty() && pq.peek().getValue() == max){
//            returnResult.add(pq.poll().getKey());
//        }
//
//        return returnResult;
    }
}
