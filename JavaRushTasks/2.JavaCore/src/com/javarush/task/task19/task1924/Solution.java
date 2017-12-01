package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        BufferedReader inputstream = new BufferedReader(new FileReader(filename));
        reader.close();

        while(inputstream.ready()){
            String data = inputstream.readLine();
            String[] strings = data.split(" ");

            for(Map.Entry<Integer,String>pair:map.entrySet()){
                int key1 = pair.getKey();
                String key = String.valueOf(key1);
                String value = pair.getValue();


                for(int i =0;i<strings.length;i++){
                    if(strings[i].equals(key)){
                        strings[i]=value;
                    }
                }

            }
            for(int j = 0;j<strings.length;j++){
                System.out.print(strings[j]+" ");
            }
            System.out.println("");

        }
        inputstream.close();

    }
}
