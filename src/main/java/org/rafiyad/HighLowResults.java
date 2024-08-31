package org.rafiyad;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class HighLowResults {

    // It will consume a list from the Google searched class
    public List<String> searchedKeys(){
        List<String> results=new ArrayList<>();
        results.add("High");
        results.add("Low");
        return results;
    }




    public static String[] findHighestAndLowestLength(ArrayList<String> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("The list is either null or empty.");
        }

        // Initialize variables to store the highest and lowest length strings
        String highestLengthString = list.get(0);
        String lowestLengthString = list.get(0);

        // Iterate through the list to find the required elements
        for (String str : list) {
            if (str.length() > highestLengthString.length()) {
                highestLengthString = str;
            }
            if (str.length() < lowestLengthString.length()) {
                lowestLengthString = str;
            }
        }

        // Return the results as an array
        return new String[]{highestLengthString, lowestLengthString};
    }



    public static void main(String[] args) {
        List<String> extrRes=new ArrayList<>();
        extrRes.add("dhaka education board");
        extrRes.add("dhaka weather");
        extrRes.add("dhaka post");
        extrRes.add("Dhaka");
        extrRes.add("Capital of Bangladesh");
        extrRes.add("dhaka stock exchange");
        extrRes.add("Dhaka University");
        extrRes.add("Public university in Dhaka, Bangladesh");
        extrRes.add("dhaka tribune");
        extrRes.add("dhaka metro");
        extrRes.add("dhaka board");
        extrRes.add("Dhaka City College");
        extrRes.add("Private college in Dhaka, Bangladesh");

        String[] result = findHighestAndLowestLength((ArrayList<String>) extrRes);
        System.out.println("Element with the highest length: " + result[0]);
        System.out.println("Element with the lowest length: " + result[1]);
/*
21
13
10
5
21
20
16
38
13
11
11
18
36
 */


    }
}
