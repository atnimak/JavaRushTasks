package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String [] getTokens(String query, String delimiter) {
        String tmp = "";
        StringTokenizer stringTokenizer = new StringTokenizer(query,delimiter);
        int i = stringTokenizer.countTokens();
        String[] result = new String[i];
        for(int j = 0;stringTokenizer.hasMoreTokens();j++){
            String token = stringTokenizer.nextToken();
            result[j]= token;
        }
        return result;

        /*String tmp = "";
        StringTokenizer stringTokenizer = new StringTokenizer(query,delimiter);
         while (stringTokenizer.hasMoreTokens()){
             String token = stringTokenizer.nextToken();
             tmp+=token+"&";
         }
         String[] result = tmp.split("&");


        return result;*/
    }
}
