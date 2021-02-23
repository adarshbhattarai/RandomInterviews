package leetcode;

import java.util.Arrays;

/**
 * @author adarshbhattarai on 2020-09-13
 * @project untitled
 */
public class DisjointSet {


    int[] s;

    public DisjointSet(int n){
        Arrays.fill(s= new int[n],-1);
    }

    public int find(int i){

        if(s[i]<0){
            return i;
        }
        return (s[i]=find(s[i]));
    }

    public boolean union(int a, int b){
        if((a=find(a))==(b=find(b))) return false;
        if(s[a]==s[b]){
            s[a]--;
        }
        if(s[a]<=s[b]){
            s[b]=a;
        }else{
            s[a]=b;
        }
        return true;
    }
}
