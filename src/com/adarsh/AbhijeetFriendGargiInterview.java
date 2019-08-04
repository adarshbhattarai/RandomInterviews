package com.adarsh;

import java.util.*;

/**
 * @author adarshbhattarai on 2019-07-28
 * @project untitled
 */
public class AbhijeetFriendGargiInterview {

    public static void main(String[] args) {

        //3.
        String first  = smallestRemovingOnecharacter("aaaabbbb");
        System.out.println(first);

        //2. Unique Occurance
        int occur = noOfRemovalsToMakeCharUnique("ccaaffddecee");
        System.out.println(occur);

    }


    private static String smallestRemovingOnecharacter(String input) {

        StringBuilder sb = new StringBuilder();
        boolean greaterFound = false;
        for(int i=0 ; i<input.length(); i++){
            if(greaterFound==false && i==input.length()-1){
                return sb.toString();
            }
            else if(greaterFound == false && input.charAt(i) >  input.charAt(i+1)) {
                greaterFound = true;
            }
            else{
                sb.append(input.charAt(i));
            }
        }

        return sb.toString();

    }

    private static int noOfRemovalsToMakeCharUnique(String input) {

        int[] dp = new int[input.length()+1];
        Map<Character,Integer> maps = new HashMap<>();
        Map<Integer,List<Character>> reverseMap = new HashMap<>();
        for(Character c : input.toCharArray())
            maps.put(c, maps.getOrDefault(c,0)+1);
        for(Map.Entry entry : maps.entrySet()){
            List l;

            if(reverseMap.containsKey(entry.getValue())){
                l = reverseMap.get(entry.getValue());
            }else{
                l = new ArrayList();
            }
            l.add(entry.getKey());
            reverseMap.put((int)entry.getValue(),l);
        }

        System.out.println(reverseMap);
        int totalCount = 0;

        dp[0] = 1;
        for(int i=1;i<dp.length;i++){

            if(reverseMap.containsKey(i)){
                int size = reverseMap.get(i).size();
                dp[i] = 1;
                int occurance = i;
                int temp = occurance;

                if(size>i){
                    totalCount += i*(size-i);
                    size = i;
                }
                while(size>1){
                    if(temp==0){
                        totalCount+= occurance;
                        break;
                    }
                    if(dp[--temp]==0){
                        totalCount += occurance-temp;
                        dp[temp] =1;
                        size--;
                    }
                }
            }
        }

        return totalCount;
    }
}
