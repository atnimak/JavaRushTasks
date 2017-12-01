package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstfile = reader.readLine();
        String secondfile = reader.readLine();


        BufferedReader fileReader = new BufferedReader(new FileReader(firstfile));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(secondfile));
        String file = "";

        while(fileReader.ready()){
            file += fileReader.readLine();

        }

        file = file.replaceAll("\\p{P}|\\t|\\n|\\r|[a-zA-Z]"," ");
        String[] mas = file.split(" ");
        String results="";

        for(int i = 0;i<mas.length;i++){
            try{
                int result = Integer.parseInt(mas[i]);
                results += result+" ";
            }catch (Exception e){

            }
        }

        fileWriter.write(results);
        reader.close();
        fileReader.close();
        fileWriter.close();



    }
}
