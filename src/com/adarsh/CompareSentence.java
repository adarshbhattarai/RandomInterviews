package com.adarsh;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by adarshbhattarai on 8/12/18.
 */
public class CompareSentence {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String a = "Hi I am cyrus from nepal khkj khjkhkhhjhjkhk jkhjkhkjhkj hjhjh check the sentence below and asd";
        String b = "Hi am cyrus from check sentence below  ";

        stringCOmpare(a,b);

    }

    private static void stringCOmpare(String a, String b) {
        // TODO Auto-generated method stub

        String[] first = a.split(" ");
        String[] second = b.split(" ");

        Queue<String> queue = new LinkedList<>();
        for (String str : first) {

            queue.add(str);

        }
        int i=0;
        while(i<second.length){
            String chars = queue.peek();
            if(second[i].equals(chars)){
                queue.poll();
                i++;

            }
            else{
                System.out.println(queue.poll());
            }

        }
        System.out.println(queue.poll());
    }
}
