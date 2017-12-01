package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader firstfile = new BufferedReader(new FileReader(args[0]));
        BufferedWriter secondfile = new BufferedWriter(new FileWriter(args[1]));
      /*  ArrayList<String> stringArrayList = new ArrayList<>();
        BufferedReader firstfile = new BufferedReader(new FileReader("file1"));
        BufferedWriter secondfile = new BufferedWriter(new FileWriter("file2"));*/

        while(firstfile.ready()){
            String data = firstfile.readLine();
            String[] strings = data.split(" ");

            for(int i = 0;i<strings.length;i++){
                Pattern p = Pattern.compile("\\d");
                Matcher m = p.matcher(strings[i]);
                strings[i]=strings[i];
                if(m.find()){
                    secondfile.write(strings[i]+" ");
                }
            }
        }
        firstfile.close();
        secondfile.close();
    }
}
