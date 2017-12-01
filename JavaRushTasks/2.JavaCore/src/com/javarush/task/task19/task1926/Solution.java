package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        BufferedReader freader = new BufferedReader(new FileReader(filename));
        while(freader.ready()){
            String data = freader.readLine();
            StringBuilder builder = new StringBuilder(data);
            builder.reverse();
            String result = builder.toString();
            System.out.println(result);

        }
        freader.close();
    }
}
