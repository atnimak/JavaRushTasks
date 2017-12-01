package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
Если числа повторяются, значит, это кому-нибудь нужно?
В данный момент это нужно нам, чтобы потренироваться решать задачи на списки.
Давайте создадим список чисел и добавим в него 10 чисел с клавиатуры.
Наша задача состоит в том, чтобы вывести на экран длину самой длинной последовательности повторяющихся чисел в списке.

 Cамая длинная последовательность
1. Создай список чисел.
2. Добавь в список 10 чисел с клавиатуры.
3. Вывести на экран длину самой длинной последовательности повторяющихся чисел в списке.

Пример для списка 2, 4, 4, 4, 8, 8, 9, 12, 12, 14:
3

Искомое значение равно 3, т.к. самая длинная последовательность повторяющихся чисел состоит из трех четверок.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            integerArrayList.add(Integer.parseInt(reader.readLine()));
        }

        int longInt = 1;
        int tmplongInt = 1;
        for (int i = 0; i < integerArrayList.size() - 1; i++) {
            if (integerArrayList.get(i) == integerArrayList.get(i + 1)) {
                tmplongInt++;
                if (longInt < tmplongInt) longInt = tmplongInt;
            } else {
                tmplongInt = 1;


            }

        }

        System.out.println(longInt);
    }
}