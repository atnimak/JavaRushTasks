package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        int id = Integer.parseInt(args[0]);
       /* String filename = "pom";
        int id  = 07;*/
        reader.close();



        String line;
        BufferedReader filereader = new BufferedReader(new FileReader(filename));

        while((line=filereader.readLine())!=null){
            String [] data = line.split(" ");
            if(Integer.parseInt(data[0])==id){
                break;
            }
        }
        filereader.close();

        System.out.println(line);
    }
}
