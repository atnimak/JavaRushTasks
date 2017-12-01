package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Solution{
        public static void main(String[] args) throws IOException {
            Map<String,Double> map = new TreeMap<>();
            Map<String,Double> map2 = new TreeMap<>();

            String filename = args[0];
            BufferedReader filereader = new BufferedReader(new FileReader(filename));

            while (filereader.ready()){
                String data = filereader.readLine();
                String[] strings = data.split(" ");
                String name = strings[0];
                double number = Double.parseDouble(strings[1]);

                if(map.containsKey(name)){
                    double sum = map.get(name) + number;
                    map.put(name,sum);
                }else{
                    map.put(name,number);
                }

            }
            filereader.close();


            double max = 0;
            for(Map.Entry<String,Double> pair:map.entrySet()){
               // System.out.println(pair.getKey()+" "+pair.getValue());
                double value = pair.getValue();
                if(value>max){
                    max = value;
                }
            }



            for(Map.Entry<String,Double> pair:map.entrySet()){
                // System.out.println(pair.getKey()+" "+pair.getValue());
                if(pair.getValue()==max){
                    map2.put(pair.getKey(),pair.getValue());
                }
            }

            for(Map.Entry<String,Double> pair:map2.entrySet()){
                System.out.println(pair.getKey());
            }

        }
}
