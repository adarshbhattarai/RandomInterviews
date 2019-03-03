package com.adarsh;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by adarshbhattarai on 3/3/19.
 */
public class DeterminasticFiniteAutomataValidNumber {

        public static void main(String [] args){

            Map<Integer,Map> determinasticFiniteAutomata = new HashMap();
            fillDFA(determinasticFiniteAutomata);
            isValidTest1("asd",  determinasticFiniteAutomata);
            isValidTest1("0",    determinasticFiniteAutomata);
            isValidTest1("+1.0", determinasticFiniteAutomata);
            isValidTest1("1e-7", determinasticFiniteAutomata);
            isValidTest1("1.2e&",determinasticFiniteAutomata);
            isValidTest1(".e&",  determinasticFiniteAutomata);
            isValidTest1("e.",   determinasticFiniteAutomata);
            isValidTest1("231e1",determinasticFiniteAutomata);
            isValidTest1(".+3",  determinasticFiniteAutomata);
            isValidTest1("-.23", determinasticFiniteAutomata);
            isValidTest1("6ee69",determinasticFiniteAutomata);

        }

        private static boolean isValidTest1(String string, Map<Integer, Map> determinasticFiniteAutomata) {
            // TODO Auto-generated method stub
            int currentstate=1;

            for(char c : string.toCharArray()){
                String currentVal=c+"";
                if(c>='0' && c<='9') currentVal="digit";
                if(c==' ') currentVal = "blank";
                if(c=='+' || c=='-') currentVal = "sign";

                if(!determinasticFiniteAutomata.get(currentstate).containsKey(currentVal)){
                    System.out.println(string +" :: => "+ false);
                    return false;
                }
                else{
                    currentstate = (int) determinasticFiniteAutomata.get(currentstate).get(currentVal);
                }
            }

            if(currentstate == 3 || currentstate == 5 || currentstate == 8 || currentstate == 9 ){
                System.out.println(string +" :: => "+ true);
                return true;
            }
            System.out.println(string +" :: => "+ false);
            return false;
        }

        private static void fillDFA(Map<Integer, Map> determinasticFiniteAutomata) {
            // TODO Auto-generated method stub

            Map<Integer,Map> dfa = determinasticFiniteAutomata;
            Map m = new HashMap();
            m.put("blank",1);
            m.put("digit",3);
            m.put(".",4);
            m.put("sign",2);
            dfa.put(1,m);

            Map m2 = new HashMap();
            m2.put("digit",3);
            m2.put(".",4);
            dfa.put(2,m2);

            Map m3 = new HashMap();
            m3.put("digit",3);
            m3.put(".",5);
            m3.put("blank",9);
            m3.put("e",6);
            dfa.put(3,m3);

            Map m4 = new HashMap();
            m4.put("digit",5);
            dfa.put(4,m4);

            Map m5 = new HashMap();
            m5.put("digit",5);
            m5.put("e",6);
            m5.put("blank",9);
            dfa.put(5,m5);

            Map m6 = new HashMap();
            m6.put("sign",7);
            m6.put("digit",8);
            dfa.put(6,m6);

            Map m7 = new HashMap();
            m7.put("digit",8);
            dfa.put(7,m7);

            Map m8 = new HashMap();
            m8.put("digit",8);
            m8.put("blank", 9);
            dfa.put(8,m8);

            Map m9 = new HashMap();
            m8.put("blank", 9);
            dfa.put(9,m9);


        }

    }

