package com.adarsh;

/**
 * Created by adarshbhattarai on 5/20/17.
 */
public class CimasApp {


    public static void main(String[] args){

        new CimasApp();
    }

    public CimasApp(){
        Cimas c1 = new ImpCimas1();
        Cimas c2 = new ImpCimas2();

        System.out.println("c1 is class "+c1.getClass().getName());
        System.out.println("c2 is class "+c2.getClass().getName());
    }
}
