package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

         FileInputStream inputStream = new FileInputStream(args[0]);
        //FileInputStream inputStream = new FileInputStream("poki");
        int[] strings = new int[256];
        while(inputStream.available()>0){
            strings[inputStream.read()]++;
        }
        inputStream.close();
        for (int i=0;i<strings.length;i++){
            if(strings[i]!=0){
                System.out.println((char)i+" "+strings[i]);
            }


        }


    }
}
