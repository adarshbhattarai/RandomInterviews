package com.adarsh;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by adarshbhattarai on 3/21/17.
 */
public class Test {

        public static void main(String [] args){
            String timeDate="00:01:07,400-234-090\n" +
                    "00:05:01,701-080-080\n" +
                    "00:05:00,400-234-090";
            int billPrice = solution(timeDate);
            System.out.println("Total bill is: "+ billPrice);
        }

        private static int solution(String timeDate) {

            Map<String,Integer> phoneDuration = new HashMap<String,Integer>();
            TreeSet<String> maximumCalls = new TreeSet<String>();
            String promoNumber="";
            int maximumDuration = 0;
            int billCharged=0;
            for(String lines :timeDate.split("\\n") ){
                String[] phoneCalls = lines.split(",");
                int callDuration = getSeconds(phoneCalls[0]);
                if(phoneDuration.containsKey(phoneCalls[1])){
                    callDuration += phoneDuration.get(phoneCalls[1]);
                }
                phoneDuration.put(phoneCalls[1],callDuration);

                if(callDuration>maximumDuration){
                    maximumDuration = callDuration;
                    maximumCalls.clear();
                    maximumCalls.add(phoneCalls[1]);
                }
                else if(callDuration == maximumDuration){
                    maximumCalls.add(phoneCalls[1]);
                }
            }
            promoNumber = maximumCalls.first();
            //System.out.println(phoneDuration);
            //System.out.println(promoNumber);
            //System.out.println(maximumDuration);

            for(String lines : timeDate.split("\\n")){
                String[] phoneCalls = lines.split(",");
                int callDuration = getSeconds(phoneCalls[0]);
                if(callDuration<300 && !promoNumber.equals(phoneCalls[1])) billCharged += callDuration*3;
                else if(callDuration>=300 && !promoNumber.equals(phoneCalls[1])){
                    if(callDuration%60==0) billCharged += callDuration/60 * 150;
                    else billCharged += (callDuration/60 + 1)*150;
                }

            }
            return billCharged;
        }

        private static int getSeconds(String phoneCall) {
            int seconds=0;
            String[] time = phoneCall.split(":");
            seconds=Integer.parseInt(time[0])*3600+Integer.parseInt(time[1])*60 +Integer.parseInt(time[2]);
            return seconds;
        }
    }


