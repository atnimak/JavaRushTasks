package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        ArrayList<String> strings = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader input = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        //BufferedReader input = new BufferedReader(new FileReader("pom"));
        while (input.ready())
        {
            int count = 0;
            String s = input.readLine();
            String[] array = s.split(" ");
            for (String x : words)
            {
                for (String y : array)
                {
                    if (y.contains(x))
                    {
                        count++;
                    }
                }
            }
            if (count == 2) System.out.println(s);
        }

//Мое пиздатейшее решение не этой задачи. В смысле все было проще.

/*        while(input.ready()){
            String data = input.readLine();
            int count=0;

           //Встечается ли первое слово?
            {


                data = data.toLowerCase();
                data = data.replaceAll("\\p{P}|\\t|\\n|\\r"," ");
                String[] mas = data.split(" ");
                int datacount=0;
                for (int i=0;i<mas.length;i++){
                    if (words.get(0).equals(mas[i])){
                        datacount++;
                    }
                }

                if(datacount>0) count++;
            }

            //Встечается ли второе слово?
            {

                data = data.toLowerCase();
                data = data.replaceAll("\\p{P}|\\t|\\n|\\r"," ");
                String[] mas = data.split(" ");
                int datacount=0;
                for (int i=0;i<mas.length;i++){
                    if (words.get(1).equals(mas[i])){
                        datacount++;
                    }
                }

                if(datacount>0) count++;
            }

            //Встечается ли третье слово?
            {


                data = data.toLowerCase();
                data = data.replaceAll("\\p{P}|\\t|\\n|\\r"," ");
                String[] mas = data.split(" ");
                int datacount=0;
                for (int i=0;i<mas.length;i++){
                    if (words.get(2).equals(mas[i])){
                        datacount++;
                    }
                }

                if(datacount>0) count++;
            }

            if(count==2) System.out.println(data);
        }*/

        input.close();


    }
}
