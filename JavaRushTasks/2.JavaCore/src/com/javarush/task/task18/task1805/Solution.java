package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fileReader = new FileInputStream(fileName);
        ArrayList<Integer> bytes = new ArrayList<>();
        while(fileReader.available() > 0) {
            int data = fileReader.read();
            if (bytes.contains(data));
            else bytes.add(data);
        }
        reader.close();
        fileReader.close();
        Collections.sort(bytes);
        for (Integer i:
             bytes) {
            System.out.print(i+" ");

        }
    }
}
