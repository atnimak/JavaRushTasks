package com.javarush.task.task18.task1816;

/* 
Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв).
Закрыть потоки.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        //String filename = "pom";
        FileInputStream file = new FileInputStream(args[0]);
        byte[] buffer = new byte[file.available()];
        if(file.available()>0){
            int count = file.read(buffer);
        }

        String test = ("abcdefghijklmnopqrstuvwxyz"+("abcdefghijklmnopqrstuvwxyz".toUpperCase()));
        int counter = 0;
        String out = new String(buffer);

        for(int i = 0;i<out.length();i++){
            if(test.contains(out.substring(i,i+1))){
                counter++;
            }

        }
        System.out.println(counter);
        file.close();
    }
}
