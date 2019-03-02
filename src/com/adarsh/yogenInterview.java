package com.adarsh;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by adarshbhattarai on 2/9/19.
 */
public class yogenInterview {
    public static void main(String[] args) {
        System.out.println(solution("codility"));

        System.out.println(solution("abbabba"));
    }

    public static  int solution(String s){

        int count=0;

        int low=0;
        int high = s.length()-1;
        Set ss = new HashSet<>();
        String prev="";
        int max =0;
        for(int i=0;i<s.length();i++){
            prev += s.charAt(i);
            ss.add(prev);
        }
        prev="";
        for(int i=s.length()-1;i>=0;i--){
            prev += s.charAt(i);
            if(ss.contains(prev))max=Math.max(max,prev.length());
        }

        return max;
    }


}
