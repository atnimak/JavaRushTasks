package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(filename1);
        FileWriter fileWriter = new FileWriter(filename2);
        int i = 0;

        while(fileReader.ready()){
            i++;
            int data = fileReader.read();
            if(i%2==0){
                fileWriter.write(data);
            }
        }

        fileReader.close();
        fileWriter.close();
    }
}
