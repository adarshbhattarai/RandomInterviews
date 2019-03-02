package com.adarsh;

/**
 * Created by adarshbhattarai on 9/9/18.
 */
public class Test {

    public static void main(String[] args){

        String testa = "/hello/worlds/cd/../home/res/abc/..";
        String expect = "/hello/worlds/home/res/";
        String actual = findNormalized(testa);

        System.out.println(actual);
        System.out.print(expect.equals(actual));
        String test = "hello/worlds/cd/";
        //System.out.println(test.replaceAll("[^\\/]*\\/$",""));

    }

    private static String findNormalized(String testa) {
        String s = testa;
        String sp[] = testa.split("/");
        String res = "";
        for(String a : sp)
            res = a.equals("..") ? res.replaceAll("[^\\/]*\\/$","") : res + a + "/";
        return res;


    }
}
