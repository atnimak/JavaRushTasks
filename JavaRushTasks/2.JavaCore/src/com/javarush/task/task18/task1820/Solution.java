package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();
       /* String filename1 = "pom";
        String filename2 = "poki";*/
        BufferedInputStream file1 = new BufferedInputStream(new FileInputStream(filename1));
        byte[] byffer1 = new byte[file1.available()];
        file1.read(byffer1);
        String s = new String(byffer1);
        String out="";
        //System.out.println(s);
        String[]strings =  s.split(" ");
        for(int i = 0;i<strings.length;i++){
            out += Math.round(Double.parseDouble(strings[i]))+" ";
        }
        //System.out.println(out);
        BufferedOutputStream file2 = new BufferedOutputStream(new FileOutputStream(filename2,false));
        file2.write(out.getBytes());
        file1.close();
        file2.close();


    }
}
