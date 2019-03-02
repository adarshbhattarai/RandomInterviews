package com.adarsh;

import java.text.CharacterIterator;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BracketSplitting {

    public static void main(String[] args) {
	// write your code here

        String test1="))))(((()(()))";
        String test ="((((";
        String test3="(())";
        String test4 = "";
      //  System.out.println(stringRes(test4));
        System.out.println(bracketsOpeningClosing(test1));

        }
    private static int bracketsOpeningClosing(String S) {

        int openingBrackets,closingBracket=openingBrackets=0;
        int i=0,j=S.length()-1;

        if(S.length()==0) return 0;
        for(;i<=j;){

            //System.out.println(i + " " +S.charAt(i)+" " + j+" "+ S.charAt(j));
            if(S.charAt(i)=='(' && openingBrackets==closingBracket){
                openingBrackets++;
                i++;
            }
            else if(S.charAt(i)==')' && openingBrackets <= closingBracket) i++;

            if(S.charAt(j)==')' && closingBracket <openingBrackets) {
                closingBracket++;
                j--;
            }
            else if(S.charAt(j)=='(' && closingBracket < openingBrackets) j--;

        }
        return S.charAt(i-1)=='(' ?(openingBrackets==closingBracket)?i:i-1:i;
    }

}
