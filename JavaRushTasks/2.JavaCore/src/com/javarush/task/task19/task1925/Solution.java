package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws  IOException{
        BufferedReader first = new BufferedReader(new FileReader(args[0]));
        BufferedWriter second = new BufferedWriter(new FileWriter(args[1]));

        /*BufferedReader first = new BufferedReader(new FileReader("file1"));
        BufferedWriter second = new BufferedWriter(new FileWriter("file2"));*/
        ArrayList<String> stringArrayList = new ArrayList<>();

        while(first.ready()){
            String data = first.readLine();
            String[] arraydata = data.split(" ");
            for(int i = 0;i<arraydata.length;i++){
                if(arraydata[i].length()>6){
                    stringArrayList.add(arraydata[i]);
                }
            }

        }

        first.close();

        for(int i = 0;i<stringArrayList.size();i++){
            if(i<stringArrayList.size()-1){
                second.write(stringArrayList.get(i)+",");
            }else{
                second.write(stringArrayList.get(i));
            }
        }
        second.close();

    }
}
