package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author adarshbhattarai on 2021-01-06
 * @project untitled
 */
public class Test {


    public static void main(String[] args) {
        Map<String,Integer> list1 = readFile("cb.txt");
        Map<String,Integer> list2 = readFile("db2.txt");
        Set<String> mismatched1 = mismatches(list1,list2);
        Set<String> mismatched2 = mismatches(list2,list1);
        System.out.println("Not present in Db2: " + mismatched1);
        System.out.println("Not present in CB: " + mismatched2);
        System.out.println("Not present in Db2 Count: " + mismatched1.size());
        System.out.println("Not present in CB Count: " + mismatched2.size());

    }
    static Set<String> mismatches(Map<String,Integer> list1, Map<String,Integer> list2){
        Set<String> mismatched2 = new HashSet<>();
        for(String s : list1.keySet()){
            if(!list2.containsKey(s) || list1.get(s) > list2.get(s)){
                mismatched2.add(s+"-"+(list1.get(s) - list2.get(s)));
            }
        }
        return mismatched2;
    }


    private static Map<String,Integer> readFile(String s) {
        Map<String,Integer> lines = new HashMap<>();try (
    BufferedReader br = Files.newBufferedReader(Paths.get(s)))    {     // read line by line 
     String line;      while ((line = br.readLine()) != null) {
         line= parseCaseId(line);     if(valid(line)){
             lines.put(line,lines.getOrDefault(line,0)+1);
         }     }   } catch (IOException e) {
            System.err.format("IOException: %s%n", e);  }   return lines;
    }


        private static String parseCaseId(String line) {   line = line.replaceAll("([\"]|_.*|,)","");
    return line.trim();
    }


    private static boolean valid(String line) {
        if(line.trim().length()<10 ) {       return false;  }
        if(!line.matches("\\d\\d\\d\\D\\D\\d+")) return false;   return true;
    }

}
