package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());

        int count = 0;
        String text = "";

        while (fileReader.ready()) {
            text += (char)fileReader.read();
        }

        text = text.toLowerCase();
        text = text.replaceAll("\\p{P}|\\t|\\n|\\r"," ");
        String[] mas = text.split(" ");

        for (int i=0;i<mas.length;i++){
            if ("world".equals(mas[i]))count++;
        }

        reader.close();
        fileReader.close();
        System.out.println(count);
    }
}
