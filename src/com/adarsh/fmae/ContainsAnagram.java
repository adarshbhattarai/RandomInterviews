package com.adarsh.fmae;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author adarshbhattarai on 2021-05-04
 * @project untitled
 */
public class ContainsAnagram {


    public static void main(String[] args) {

        //letters same

        String input = "mary joined army";
        String input2 = "";
        //
        //mary
        //army
        //Print if the sentence contains anagram.
        isAnagram(input);
        isAnagram(input2);

    }

    private static void isAnagram(String input) {

        input = input.toLowerCase();
        boolean isAnagram=false;
        String[] words = input.split(" ");
        Set<String> anagramSet = new HashSet<>();

        for(String word : words){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);
            if(anagramSet.contains(sortedString)){
                isAnagram = true;
                break;
            }
            anagramSet.add(sortedString);
        }
        if(isAnagram){
            System.out.println("Yes, this is an Anagram");
        }
        else{
            System.out.println("No, this is not an Anagram");
        }
    }
}
