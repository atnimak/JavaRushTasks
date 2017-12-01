package com.javarush.task.task22.task2209;

import javax.xml.bind.SchemaOutputResolver;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


/*
Составить цепочку слов
*/
public class Solution  {
    public static void main(String[] args) throws IOException {
        /*ArrayList<String> strings = new ArrayList<>();*/
        //System.out.println("Начало работы");
        StringBuilder strings = new StringBuilder();
        // System.out.println("Создали стрингбилдер");

        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        //System.out.println("Создаем файлридер");
        //System.out.println("Введи имя файла");
        BufferedReader filereader = new BufferedReader(new FileReader(reader.readLine()));
       /* BufferedReader filereader = new BufferedReader(new FileReader("pom"));*/

        // System.out.println("Читаем файл");

        while (filereader.ready()){
            strings.append(filereader.readLine());
        }

        //System.out.println("Запускаем getLines");


        StringBuilder result = getLine(strings.toString().split(" "));
        //System.out.println("Результат работы getLine");
        System.out.println();
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sBuilder = new StringBuilder();
        ArrayList<String> strings = new ArrayList<>();

        Collections.addAll(strings,words);
        if (strings.size() == 0){
            return new StringBuilder();
        }
        ArrayList<String> stringsCopy = new ArrayList<>(strings);
        int count = 1;

        sBuilder.append(strings.get(0));
        strings.remove(0);

        while(strings.size()>0){
            for(int i = 0;i<strings.size();){
                String one = strings.get(i);
                String two = sBuilder.toString();

                if(String.valueOf(one.charAt(0)).equalsIgnoreCase(String.valueOf(two.charAt(two.length()-1)))){
                    //Добавляем в конец sBuilder`a
                    sBuilder.append(" ").append(one);
                    strings.remove(i);
                    count++;
                    //continue;

                }else if(String.valueOf(one.charAt(one.length()-1)).equalsIgnoreCase(String.valueOf(two.charAt(0)))){
                    //Добавляем в начало sBuilder`a

                    sBuilder.insert(0," ");
                    sBuilder.insert(0,one);
                    count++;
                    strings.remove(i);

                }else {
                    // System.out.println("Неподходящие слова: ");
                    // System.out.println(strings.get(i));
                    strings.remove(i);
                }
            }

            if(stringsCopy.size()>count){
                //Проверяем, если в отсортированном массиве слов меньше, чем в начальном. Чистим массив, копируем в него начальные данные,
                //перемешиваем, чтобы изменить последовательность слов и перезапускаем.
                //Потому что все слова должны войти в конечный массив.
                strings.clear();
                strings=new ArrayList<>(stringsCopy);
                sBuilder= new StringBuilder();
                Collections.shuffle(strings);
                count=1;
                sBuilder.append(strings.get(0));
                strings.remove(0);
                continue;
            }
        }
        return sBuilder;



    }
}
