package com.adarsh.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author adarshbhattarai on 2020-07-14
 * @project untitled
 */
public class Patiram2020Amazon2 {

    //[[apple,apple]
    //[orange,anything,orange, anything]]

    //x,x,apple, apple , orange, banana, orange -> true
    //Return 1 or 0;

    public static void main(String[] args) {


        List<List<String>> inputs = new ArrayList<>();
        inputs.add(new ArrayList());
        inputs.add(new ArrayList());
        inputs.get(0).add("apple");
        inputs.get(0).add("apple");
        inputs.get(1).add("orange");
        inputs.get(1).add("anything");
        inputs.get(1).add("orange");
        inputs.get(1).add("anything");

        List<String> cart = new ArrayList<>();
        cart.add("x");
        cart.add("orange");
        cart.add("orange");
        cart.add("orange");
        cart.add("orange");
        cart.add("orange");
        cart.add("banana");
        cart.add("orange");
        cart.add("banana");

        Patiram2020Amazon2 patiram2020Amazon2 = new Patiram2020Amazon2();
        System.out.println(patiram2020Amazon2.checkWinner(inputs,cart));


    }
    int anythingCount=0;
    Map<Integer, List> anythings = new HashMap<Integer,List>();
    public int checkWinner(List<List<String>> codeList, List<String> shoppingCart){
        int curr=0;
        if(codeList.isEmpty())
            return 1;
        int i=0;
        for(List<String> codes : codeList){
            anythings.put(i,new ArrayList<>());
            if((curr=matched(codes,shoppingCart,curr,i))<0){
                return 0;
            }
            i++;
        }
        return 1;
    }

    private int matched(List<String> codes, List<String> shoppingCart, int curr, int level) {

        int i=curr;
        while(curr<=shoppingCart.size()){
            if(isMatch(codes,shoppingCart,0,curr, level)){
                return curr+codes.size();
            }
            curr++;
        }
        return -1;
    }

    private boolean isMatch(List<String> codes, List<String> shoppingCart, int codeStart, int curr, int level) {

        boolean isMatch = true;
        if(codeStart==codes.size())
            return true;
        if(codeStart>=codes.size() || curr>=shoppingCart.size())
            return false;
        if(codes.get(codeStart).equals(shoppingCart.get(curr))){
            isMatch &= isMatch(codes,shoppingCart,codeStart+1,curr+1,level);
        }else if(codes.get(codeStart).equals("anything")){
            anythingCount++;
            anythings.get(level).add(shoppingCart.get(curr));
            isMatch &=true;
        }else{
            isMatch&=false;
        }

        return isMatch;
    }

}
