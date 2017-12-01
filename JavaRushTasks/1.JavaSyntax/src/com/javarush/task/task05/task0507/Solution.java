package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое

Вводить с клавиатуры числа и вычислить среднее арифметическое.
Если пользователь ввел -1, вывести на экран среднее арифметическое всех чисел и завершить программу.
-1 не должно учитываться.

Пример для чисел 1 2 2 4 5 -1:
2.8

Пример для чисел 4 3 2 1 -1:
2.5
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.ArrayList;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> stringList = new ArrayList<String>();
        String stop = "-1";
        String s = "";

        while(!s.equals(stop)){
            s = reader.readLine();
            stringList.add(s);
            if(s.equals(stop)){
                stringList.remove(stringList.size()-1);
            }
        }
        //System.out.println(stringList);
        int sum = 0;
        for(int i = 0;i<stringList.size();i++){
            sum = sum + Integer.parseInt(stringList.get(i));
        }
        //System.out.println(sum);
        double middle = (double)sum/(double)stringList.size();
        System.out.println(middle);

    }
}

