package com.adarsh;

import java.util.HashSet;
import java.util.Set;

/**
 * @author adarshbhattarai on 2019-07-19
 * @project untitled
 */
public class JPMorganChasePatrick {

    LinkedListI ll;
    public static void main(String[] args) {
        //1.Stack impl

        JPMorganChasePatrick patrick = new JPMorganChasePatrick();

        int[] vql = {1,2,3,4};

        for(int i : vql)
            patrick.push(i);

        patrick.popALL();

        //Question twwo, basically trim
        String input = "how are you, abc";
        String out = "how re you";

        String input2 = "hello world,def";
        String out2 = "hllo worl";

        String output = patrick.trim(input2);
        System.out.println(output);
    }

    private String trim(String input) {
        String[] val = input.split(",");
        String first = val[0];
        String next = val[1];
        next = next.trim();
        StringBuilder builder= new StringBuilder();
        Set<Character> chars = new HashSet<>();
        for(Character character : next.toCharArray()){
            chars.add(character);
        }
        for (Character character : first.toCharArray()){
            if(!chars.contains(character)){
                builder.append(character);
            }
        }
        String output = builder.toString();


        return  output.trim();
    }

    void popALL() {

        while(ll !=null){

            System.out.println(pop() +" ");
            if(ll !=null) pop();

        }
    }


    void push(int i){
        if(ll==null)
            ll = new LinkedListI(i);

        else {
            LinkedListI stk = new LinkedListI(i);
            stk.next = ll;
            ll=stk;
        }
    }

    int pop(){
        if(ll==null)
            return 0;

        int val = ll.val;
        ll = ll.next;
        return val;
    }

}

class LinkedListI{

  int val;
  LinkedListI next;
  LinkedListI(int val){
      this.val = val;
  }
}