package com.adarsh;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author adarshbhattarai on 2021-05-25
 * @project untitled
 */
public class SamirDai {

    public static void main(String[] args) {

        int numberOfSkilledPlayer=4;
        int minPlayers=3;
        double com=0;
        for(;minPlayers<=numberOfSkilledPlayer; minPlayers++)
            com+=fact(numberOfSkilledPlayer)/(fact(numberOfSkilledPlayer-minPlayers)*fact(minPlayers));

        System.out.println(com);
    }


    //Question 1:
    public static int priceCheck(List<String> products, List<Float> productPrices, List<String> productSold, List<Float> soldPrice) {
        // Write your code here
        Map<String,Float> productPriceMap = new HashMap();
        for(int i=0;i<productPrices.size();i++){
            productPriceMap.put(products.get(i),productPrices.get(i));
        }
        int count=0;
        int index=0;
        for(String soldProduct : productSold){

            if(Float.compare(soldPrice.get(index++),productPriceMap.get(soldProduct)) != 0 ) count++;
        }

        return count;
    }

    //Question 2:
    public static int countTeams(List<Integer> skills, int minPlayers, int minLevel, int maxLevel) {

        int numberOfSkilledPlayer=0;

        for(int skill: skills){
            if(skill>=minLevel && skill<=maxLevel){
                numberOfSkilledPlayer++;
            }
        }
        double com=0;

        for(;minPlayers<=numberOfSkilledPlayer; minPlayers++)
            com+=fact(numberOfSkilledPlayer)/(fact(numberOfSkilledPlayer-minPlayers)*fact(minPlayers));

        return (int) com;
    }

    static double fact(double n)
    {
        int i=1;
        double fact=1;
        while(i<=n)
        {
            fact=fact*i;
            i++;
        }
        return fact;
    }

    }
