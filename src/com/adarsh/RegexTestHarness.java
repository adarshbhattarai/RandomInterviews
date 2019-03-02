package com.adarsh;

import java.io.Console;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by adarshbhattarai on 4/22/17.
 */
public class RegexTestHarness {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        while (true) {

            System.out.println("Enter your regex: ");
            String line = s.nextLine();
            System.out.println("Enter input string to search: ");
            String reg = s.nextLine();
            Pattern pattern =
                    Pattern.compile(line);

            Matcher matcher =
                    pattern.matcher(reg);

            boolean found = false;
            while (matcher.find()) {
                System.out.format("I found the text" +
                                " \"%s\" starting at " +
                                "index %d and ending at index %d.%n",
                        matcher.group(),
                        matcher.start(),
                        matcher.end());
                found = true;
            }
            if(!found){
                System.out.format("No match found.%n");
            }
        }
    }

}
