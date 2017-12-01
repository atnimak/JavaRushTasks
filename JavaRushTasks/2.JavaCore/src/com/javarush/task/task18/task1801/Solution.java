package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        //ArrayList<Integer> list = new ArrayList<>();
        int max=0;

        FileInputStream inputStream = new FileInputStream(filename);

        while(inputStream.available()>0){
            int data = inputStream.read();
            //list.add(data);
            if(data>max){
                max = data;
            }

        }
        System.out.println(max);


  /*      for(int i = 0;i<list.size()-1;i++){
            if(list.get(i)>max){
                max = list.get(i);
            }
        }*/
        //Collections.sort(list);

        //System.out.println(list.get(list.size()-1));

        reader.close();
        inputStream.close();

    }
}
