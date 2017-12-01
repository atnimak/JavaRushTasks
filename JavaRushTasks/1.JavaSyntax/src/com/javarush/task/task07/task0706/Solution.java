package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома

1. Создать массив на 15 целых чисел.
2. Ввести в него значения с клавиатуры.
3. Пускай индекс элемента массива является номером дома, а значение — число жителей, проживающих в доме.
Дома с нечетными номерами расположены на одной стороне улицы, с четными — на другой. Выяснить, на какой стороне улицы проживает больше жителей.
4. Вывеси на экран сообщение: «В домах с нечетными номерами проживает больше жителей.» или «В домах с четными номерами проживает больше жителей.»

Примечание:
дом с порядковым номером 0 считать четным.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] loop = new int [15];
        for(int i = 0;i<loop.length;i++){
            loop[i] = Integer.parseInt(reader.readLine());
        }
       /* int[] loop = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};*/

        int even = 0;//56
        int odd = 0;//49

        for(int i = 0;i<loop.length;i=i+2){
            int tmp = loop[i];
            even = even+tmp;
        }

        for(int i = 1;i<loop.length;i=i+2){
            int tmp1 = loop[i];
            odd = odd+tmp1;
        }

       /* System.out.println("В домах с четными номерами проживает "+ even);
        System.out.println("В домах с нечетными номерами проживает "+ odd);*/

        if(even>odd){
            System.out.println("В домах с четными номерами проживает больше жителей.");
        }else if(odd>even){
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }


    }
}
