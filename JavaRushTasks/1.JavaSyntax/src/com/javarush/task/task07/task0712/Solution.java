package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
1. Создай список строк.
2. Добавь в него 10 строчек с клавиатуры.
3. Узнай, какая строка в списке встретится раньше: самая короткая или самая длинная.
Если таких строк несколько, то должны быть учтены самые первые из них.
4. Выведи на экран строку из п.3.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<10; i++)
        {
            list.add(reader.readLine());
        }
        String shortestString = list.get(0);
        int indexOfShortest=0;
        for (int i=1; i<list.size(); i++) {
            if (shortestString.length() < list.get(i).length()) {
                shortestString = list.get(i);
                indexOfShortest = i;
            }
        }
        String longestString = list.get(0);
        int indexOfLongest=0;
        for (int i=1; i<list.size(); i++) {
            if (longestString.length() > list.get(i).length()) {
                longestString = list.get(i);
                indexOfLongest = i;
            }
        }
        if (indexOfShortest<indexOfLongest) System.out.println(list.get(indexOfShortest));
        if (indexOfShortest>indexOfLongest) System.out.println(list.get(indexOfLongest));
    }

    /*public static void main(String[] args) throws Exception {
       //Еще одно рабочее решение

        //создали массив, накидали элементов
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(int  i = 0;i<10;i++){
            list.add(reader.readLine());
        }

        //ищем самую короткую строку
        String shortestString = list.get(0);
        int lengthOfShortest = list.get(0).length();

        for(int i = 0;i<list.size();i++){
            int tmp = list.get(i).length();
            if(tmp<lengthOfShortest){
                lengthOfShortest = tmp;
                shortestString = list.get(i);
            }
        }
        System.out.println("Самая короткая строка "+shortestString+". Его индекс "+list.indexOf(shortestString));

        //ищем самую длинную строку
        String longestString = list.get(0);
        int lengthOfLongest = list.get(0).length();

        for(int i = 0;i<list.size();i++){
            int tmp;
            tmp = list.get(i).length();
            if(tmp>lengthOfLongest){
                lengthOfLongest = tmp;
                longestString = list.get(i);
            }
        }

        System.out.println("Самая длинная строка "+longestString+". Его индекс "+list.indexOf(longestString));
                
        if(list.indexOf(longestString)>list.indexOf(shortestString)){
            System.out.println(shortestString);
        }else if(list.indexOf(longestString)<list.indexOf(shortestString)){
            System.out.println(longestString);
        }

    }*/
}
