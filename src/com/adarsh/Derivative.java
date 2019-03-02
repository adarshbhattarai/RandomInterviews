package com.adarsh;

/**
 * Created by adarshbhattarai on 6/22/17.
 */
public class Derivative {

    public static void  main (String [] args){
        String eq1 = "2x^2 + 3";

        Derivative d = new Derivative();
        System.out.println( d.secondDerivative(eq1) + " Expected: "+ "4");

    }


    String secondDerivative(String equation) {


        String[] contents =  equation.split(" ");
        String output = "";
        for(String a:contents){
            if(a.equals("+") || a.equals("-")){
                output +=a;
            }
            else{

                String[] b = a.split("\\^");
                if(b.length==1)
                    output += 0+"";
                else if(!b[0].contains("x") || Integer.parseInt(b[1])<2 &&
                        Integer.parseInt(b[1])>-1) output += 0+"";
                else{
                    int power = Integer.valueOf(b[1]);
                    int coeff = power * (power-1);
                    coeff *= (b[0].length()>1)? Integer.valueOf(b[0].replace("x","")):
                            1;
                    output += coeff + "";
                    output += (power-2)==1?"x":(power-2)==0? "":"x^"+(power-2);
                }

            }
        }

        if(output.length()>1){
            if(output.charAt(0)== '0') output = output.substring(1);
            if(output.charAt(0)=='+') output = output.substring(1);
        }

        output =  output.length()>1?output.replaceAll("\\+0","").replaceAll("\\-0",""):output;

        if(output.isEmpty()) output = "0";

        return output;


    }
}
