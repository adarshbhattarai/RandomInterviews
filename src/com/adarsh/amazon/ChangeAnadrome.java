package com.adarsh.amazon;

/**
 * @author adarshbhattarai on 2021-05-06
 * @project untitled
 */
public class ChangeAnadrome {

    public static void main(String[] args) {

        int out= changeToAnadrome("tatoo");
        int out2= changeToAnadrome("abcb");
        int out3= changeToAnadrome("abab");
        int out4= changeToAnadrome("abc");

        System.out.println(out+" " + out2 +" "+out3 + " " +out4);
    }

    private static int changeToAnadrome(String word) {

        int map[] = new int[26];
        for(char c : word.toCharArray()){
            map[c-97]++;
        }

        int totalOdd=0;
        for(int i=0;i<26;i++){
            totalOdd+= map[i]%2;
        }

        return totalOdd==0? 0: totalOdd-1;
    }
}
