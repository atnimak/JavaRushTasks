package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
Иерархия — первый страж порядка и боевое оружие диктатуры.
О диктатуре подумаем поже, а пока составим список из 10 слов. Введём их с клавиатуры.
Наша задача состоит в том, чтобы проверить, является ли список упорядоченным по возрастанию длины строки.
Если нет, выводим на экран номер первого элемента, нарушающего такую упорядоченность.

1. Введи с клавиатуры 10 слов в список строк.
2. Определить, является ли список упорядоченным по возрастанию длины строки.
3. В случае отрицательного ответа вывести на экран номер первого элемента, нарушающего такую упорядоченность.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //создаем списко и наполняем значениями
        ArrayList<String> stringList = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0;i<10;i++){
            stringList.add(reader.readLine());

        }

        for(int i = 0;i<stringList.size()-1;i++){
            int lengthOfFirst = stringList.get(i).length();
            int lengthOfSecond = stringList.get(i+1).length();

            if(lengthOfFirst>lengthOfSecond){
                System.out.println(i+1);
                break;
            }
        }


    }
}

