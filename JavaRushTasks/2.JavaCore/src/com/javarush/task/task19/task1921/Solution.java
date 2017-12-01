package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/* 
Хуан Хуанович
*/

/*public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();
    public static void main(String[] args) throws IOException, ParseException {
       String filename = args[0];
       // String filename = "file1";
        BufferedReader filereader = new BufferedReader(new FileReader(filename));

        while (filereader.ready()){
            String data = filereader.readLine();
            String[] strings = data.split(" ");
            String name ="";
            String date = "";
            Integer test;
            int indexoffirstInteger;

            dot:
            for(int i=0;true;){
                    try{
                        test = Integer.parseInt(strings[i]);
                        if(test instanceof Integer) {
                            indexoffirstInteger = i;
                            break;
                        }

                    }catch (Exception e){
                        i++;
                        continue dot;
                    }
            }


            for(int j=0;j<indexoffirstInteger;j++){
                name += strings[j]+" ";
            }

            name = name.trim();

            for(int k = indexoffirstInteger;k<strings.length;k++){
                date += strings[k];
            }

            date = date.replaceAll(" ","");

           if(date.length()<8){
               StringBuffer buffer = new StringBuffer(date);
               buffer.insert(2,0);
               date = buffer.toString();
           }

            Integer year = Integer.parseInt(date.substring(4,8));
            Integer month = (Integer.parseInt(date.substring(2,4)))-1;
            Integer day = Integer.parseInt(date.substring(0,2));
            Date birthDay = new GregorianCalendar(year, month, day).getTime();
            Person p = new Person(name,birthDay);
            PEOPLE.add(p);
        }
        filereader.close();

        *//*for(int j = 0;j<PEOPLE.size();j++){
            System.out.println(PEOPLE.get(j));
        }*//*

    }
}*/


public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
        String fileName = args[0];
        String input;
        ArrayList<String> fileList = new ArrayList<String>();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        while ((input = fileReader.readLine()) != null)
            fileList.add(input);
        fileReader.close();

        for (String aFileList : fileList)
        {
            String[] stringArray = aFileList.split(" ");
            String name = "";
            for (int i = 0; i < stringArray.length-3; i++) {
                if (i == stringArray.length-4)
                    name = name+stringArray[i];
                else
                    name = name+stringArray[i]+" ";
            }
            int year = Integer.parseInt(stringArray[stringArray.length-1]);
            int month = Integer.parseInt(stringArray[stringArray.length-2])-1;
            int day = Integer.parseInt(stringArray[stringArray.length-3]);
            Date birthDay = new GregorianCalendar(year, month, day).getTime();
            PEOPLE.add(new Person(name, birthDay));
        }
    }
}