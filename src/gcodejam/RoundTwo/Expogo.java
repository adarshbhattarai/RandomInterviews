package gcodejam.RoundTwo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author adarshbhattarai on 2020-04-19
 * @project untitled
 */
public class Expogo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = sc.nextInt();
        for(int i=1;i<=testcases;i++) {
            int first = sc.nextInt();
            int last = sc.nextInt();
            System.out.println("Case #"+i+": "+ solve(first,last) + " " + solvea(first,last,0));
        }
    }

    static String solve(int a, int b){
        int[][] DIRS = {{0,1},{1,0},{-1,0},{0,-1}};
        String[] eve = {"N","E","W","S"};
        if((Math.abs(a)%2==0 && Math.abs(b)%2==0)||(Math.abs(a)%2==1 && Math.abs(b)%2==1) )
             return "IMPOSSIBLE";
        Node n=new Node(new int[]{0,0,0}, "");
        int t=0;
        Queue<Node> qu = new LinkedList();
        //qu.add(n);
        qu.add(new Node(new int[]{1,0,1},"E"));
        qu.add(new Node(new int[]{0,1,1},"N"));
        qu.add(new Node(new int[]{-1,0,1},"W"));
        qu.add(new Node(new int[]{0,-1,1},"S"));
        while(!qu.isEmpty()){
                Node val = qu.poll();
                int[] values=val.values;
                String path=val.path;
                if(values[0]==a && values[1]==b){
                    return path;
                }
                int nextPath=1<<values[2];
                int i=0;
                for(int[] dir: DIRS){
                    int nf=values[0]+dir[0]*nextPath;
                    int nl=values[1]+dir[1]*nextPath;
                    qu.add(new Node(new int[]{nf,nl,values[2]+1},path+eve[i]));
                    i++;
                }
        }
        return "IMPOSSIBLE";
    }

    static boolean isIncircle(int x, int y, int [] valurs){
        int centerX=valurs[0];
        int centerY=valurs[1];
        int radious=1<<valurs[2];

        return ((centerX-x)*(centerX-x) + (centerY -y)* (centerY-y))<= radious*radious;

    }

    static String solvea(int a, int b,int c){
        String s="";
        int nexta , nextb=0;
        nexta=a;
        nextb=b;

        if(a==0 && b==0)
            return "";
        if(c==0&& (Math.abs(a)%2==0 && Math.abs(b)%2==0)||(Math.abs(a)%2==1 && Math.abs(b)%2==1) )
            return "IMPOSSIBLE";

        if(a%2!=0){
            int  tmp=a;
            a=b;
            b=tmp;
            //go east or west

            //Go North or South
            //a is even
            //next a is even, next b should be odd
            if(((b+1)/2)%2==0){
                s="N";//next b-1
               nexta=b-1;

            }else{
                s="S";
                nexta=b+1;
            }
            if(b<0){
                if(s.equals("S")){
                    s="N";
                }else{
                    s="S";
                }
            }
            if((a/2)%2!=0){
                if(s.equals("S")){
                    s="N";
                }else{
                    s="S";
                }
            }

            if(s.equals("N")) s="E";
            else s="W";
            tmp=a;
            a=b;
            b=tmp;
        }else{
            //Go North or South
            //a is even
                //next a is even, next b should be odd
                if(((b+1)/2)%2==0){
                    s="N";//next b-1
                    nextb=b-1;
                }else{
                    s="S";
                    nextb=b+1;
                }
                if(b<0){
                    if(s.equals("S")){
                        s="N";
                    }else{
                        s="S";
                    }
                }
            if((a/2)%2!=0){
                if(s.equals("S")){
                    s="N";
                }else{
                    s="S";
                }
            }
        }
        return  s+solvea(nexta/2,nextb/2,c+1);
    }
}

class Node{
    int[] values;
    String path;

    Node(int[] values, String path){
        this.path=path;
        this.values=values;

    }
}
