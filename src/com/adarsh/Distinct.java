package com.adarsh;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by adarshbhattarai on 3/19/17.
 */
public class Distinct {
    Date dt1,dt2;
    public int solution(String S, String T) {
        int counter = 0;
        Set<Integer> set = new HashSet<Integer>();
        DateFormat formatter = new SimpleDateFormat("hh:mm:ss");

        try {
            dt1 = formatter.parse(S);
            dt2 = formatter.parse(T);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt1);

        while (dt1.compareTo(dt2) <= 0) {
            System.out.println(dt1);
            String a =calendar.getTime().toString().substring(11,19);
            String [] values = a.split(":");

            for(String val : values){
                set.add(Integer.parseInt(String.valueOf(val.charAt(0))));
                set.add(Integer.parseInt(String.valueOf(val.charAt(1))));
            }
            if(set.size()<3) counter++;
            System.out.println(set);
            set.clear();
            calendar.add(Calendar.SECOND, 1);
            dt1 = calendar.getTime();

        }
        return counter;
    }

    public static void main(String[] args) {
        Distinct sol = new Distinct();
        //int value = sol.solution("22:22:22", "22:22:24");
       // System.out.println("Should be 3 :" + value);
      //  int value3 = sol.solution("20:58:43", "20:58:44");

        int value1 = sol.solution("13:12:00", "13:12:55");
        System.out.println("Should be 1 :" + value1);
    }
}

