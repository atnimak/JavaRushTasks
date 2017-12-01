package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader filereader=null;
        BufferedReader filereader2 = null;
        String filenameFirst = null;
        String filenameSecond = null;
        /*filenameFirst = "pom";
        filenameSecond = "poki";*/
        
        try {
            filenameFirst = reader.readLine();
            filenameSecond = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String line;
            filereader = new BufferedReader(new FileReader(filenameFirst));
            while((line = filereader.readLine()) != null){
                allLines.add(line);
            }

            line = null;

            filereader2 = new BufferedReader((new FileReader(filenameSecond)));
            while((line = filereader2.readLine())!=null){
                forRemoveLines.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }

        try {
            reader.close();
            filereader.close();
            filereader2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void joinData() throws CorruptedDataException {
       // System.out.println("forRemoveLines " + forRemoveLines);
       // System.out.println("allines "+allLines);
        boolean containsyes = true;
        for(int i = 0;i<forRemoveLines.size();i++){
            if(!(allLines.contains(forRemoveLines.get(i)))){
             containsyes = false;
             break;
            }
        }

        if(containsyes){
            for(int i1 = 0;i1<forRemoveLines.size();i1++){
                for(int j = 0;j<allLines.size();j++){
                    if(forRemoveLines.get(i1).equals(allLines.get(j))){
                        allLines.remove(j);
                    }
                }
            }
        }else{
            allLines.clear();
            CorruptedDataException e = new CorruptedDataException();
            throw e;
        }





       // System.out.println("forRemoveLines " + forRemoveLines);
       // System.out.println("allines "+allLines);

    }
}
