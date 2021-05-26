package com.adarsh.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adarshbhattarai on 2021-04-01
 * @project untitled
 *
 * HackerRank interview
 */
public class Patiram2021OA2 {

    public static void main(String[] args) {

        List<String> out = new ArrayList<>();
        out.add("L");
        out.add("RGRG");
        out.add("G");
        out.add("GRGL");


        System.out.println(doesCircleExist(out));
    }

    public static List<String> doesCircleExist(List<String> commands){


        List<String> returnList = new ArrayList();

        for(String command: commands){
            if(circles(command)){
                returnList.add("YES");
            }else{
                returnList.add("NO");
            }
        }

        return returnList;
    }

    public static boolean circles(String command){
        int i=0;
        int x=0;
        int y=0;
        int dir=0;
        while(i<4){
            for(char c : command.toCharArray()){
                if(c=='R'){
                   dir=(dir+1)%4;
                }else if(c=='L'){
                    dir=(4+dir-1)%4;
                }else{
                    if(dir==0){
                        y++;
                    }else if(dir==1){
                        x++;
                    }else if(dir==2){
                        y--;
                    }else{
                        x--;
                    }

                }
            }
            i++;
        }

        return x==0 && y==0;
    }


}
