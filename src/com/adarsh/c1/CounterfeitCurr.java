package com.adarsh.c1;

import java.util.*;

/**
 * @author adarshbhattarai on 2021-05-02
 * @project untitled
 */
public class CounterfeitCurr {

    public static void main(String[] args) {

        List input = new ArrayList();
        input.add("RED190250E");
        input.add("RFV201111T");
        input.add("TYU20121000E");
        input.add("AAA198710B");
        input.add("AbC200010E");

        countCounterfeit(input);
    }

    public static int countCounterfeit(List<String> serialNumber) {
        // Write your code here

        Set denominations = new HashSet();
        denominations.add(10);
        denominations.add(20);
        denominations.add(50);
        denominations.add(100);
        denominations.add(200);
        denominations.add(500);
        denominations.add(1000);

        if(serialNumber.isEmpty()) return 0;
        int count=0;
        for( String sNumber : serialNumber){
            count+=isCounterFeit(sNumber, denominations);
        }

        return count;
    }

    private static int isCounterFeit(String sNumber, Set denominations) {

        //1 validate Numbers
        //2 validate next 3chars, distinct and all uppercase letters
        //3 next 4 characters year between 1900 and 2019
        //next is Currency
        //last character, must end with one uppercase English letter.

        //1. validate number
        if(sNumber.length()<10 || sNumber.length()>12)return 0;

        //2. validate next 3chars, distinct and all uppercase letters
        Set s = new HashSet<>();
        for(int i=0;i<3;i++) {
            char ch = sNumber.charAt(i);
            if(isUpperCase(ch)){
                s.add(sNumber.charAt(i));
            }
        }
        if(s.size()<3) return 0;
        s.clear();

        //3. next 4 chars(3-7), year between 1900 - 2019
        String nextChars = sNumber.substring(3,7);
        if(isNumeric(nextChars)){
            int number = Integer.parseInt(nextChars);
            if(number<1900 || number>2019) return 0;
        }else{
            return 0;
        }
        //4. last character UpperCase
        if(!isUpperCase(sNumber.charAt(sNumber.length()-1))) return 0;

        String amount = sNumber.substring(7,sNumber.length()-1);
        if(!isNumeric(amount)) return 0;

        int returnAmount = Integer.parseInt(amount);
        //Check the number in Between is of valid Denomination
        return denominations.contains(returnAmount)?returnAmount:0;
    }


    private static boolean isNumeric(String nextChars) {
        try{
            Integer.parseInt(nextChars);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private static boolean isUpperCase(Character ch) {
        return ch >= 'A' && ch<='Z';
    }
}
