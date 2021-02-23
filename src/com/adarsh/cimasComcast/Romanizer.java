package com.adarsh.cimasComcast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author adarshbhattarai on 2019-12-17
 * @project untitled
 */
public class Romanizer {

    public static void main(String[] args) {

        List l = Arrays.asList(new Integer[]{49});
        System.out.println(romanizer(l));
    }

    public static List<String> romanizer(List<Integer> numbers){

        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        List<String> returnList = new ArrayList<String>();
        for(Integer nums : numbers){
            returnList.add(convertToRoman(nums,values,strs));
        }
        return returnList;
    }

    private static String convertToRoman(int num,int[] values, String[] strs) {
       StringBuilder sb = new StringBuilder();
        for(int i=0;i<values.length;i++){
            while(num>=values[i]){
                num-=values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }

    private static void fillLookUp(HashMap<Integer, String> lookUp) {
    }
}
