package com.adarsh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by adarshbhattarai on 4/25/19.
 */
public class QLQuestions {
    public static void main(String[] args) {

        int[] a = {5,1,3,4,6,2};

        Stack<Integer> stack = new Stack();
        int[] result = new int[a.length];

        Arrays.fill(result,-1);

        int finalSum=0;

        for(int i=0;i<a.length;i++){
            while(!stack.isEmpty() && a[i]<a[stack.peek()]){
                result[stack.pop()] = a[i];
            }
            stack.push(i);
        }

        for(int i=0;i<result.length;i++){
           if(result[i] != -1)
            finalSum += a[i] - result[i];

        }
        System.out.println(Arrays.toString(result));
/*

        for(int i=a.length-1 ;i>=0;i--){
            stack.push(a[i]);
        }

        List indices = new ArrayList();
        int totalSum = 0;
        for(int i=0;i<a.length;i++){

            int length = stack.size();


            if(a.length-i == length){

                stack.pop();
                Stack<Integer> sec = new Stack();
                while(!stack.isEmpty() && stack.peek()>a[i]){
                    sec.add(stack.pop());
                }
                if(stack.isEmpty()){
                    totalSum+=a[i];
                    indices.add(i);
                }else{
                    totalSum+= a[i]-stack.peek();
                }

                while(!sec.isEmpty()){
                        stack.add(sec.pop());
                }
            }
        }

        System.out.println(totalSum);
        System.out.println(indices);
*/


    }
}
