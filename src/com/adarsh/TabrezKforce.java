package com.adarsh;

import java.util.regex.Pattern;

/**
 * Created by adarshbhattarai on 3/6/19.
 */
public class TabrezKforce {

    public static void main(String[] args) {
        //replace K before f

       String out= addKbeforeFs("foRce");
       String second = addKbeforeANyFs("kforce");
       System.out.println(second);
    }

    private static String addKbeforeANyFs(String kforce) {

        return kforce.replaceAll("[f]" ,"k$1");

    }

    private static String addKbeforeFs( String input) {

       StringBuilder returnString = new StringBuilder();

       for(char c : input.toCharArray()){
           if(c=='f'){
               returnString.append("Kf");
           }else if(c >64 && c<91){
               returnString.append("K"+c);
           }else{
               returnString.append(c);
           }
       }
       return returnString.toString();
    }
}
