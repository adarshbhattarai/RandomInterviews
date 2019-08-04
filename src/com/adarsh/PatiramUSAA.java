package com.adarsh;

/**
 * @author adarshbhattarai on 2019-06-26
 * @project untitled
 */
public class PatiramUSAA {

    public static void main(String[] args) {

        MyCalculator calc = new MyCalculator();
        try {
            System.out.println(calc.power(0,0));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class MyCalculator{


    int power(int a , int b) throws Exception {

        if(a<0 ||  b<0)
            throw new Exception("n and p should be non-negative");

        return b==0?1:b==1?a: ( (b%2<1? 1 : a ) * power(a*a,b/2));
    }
}
