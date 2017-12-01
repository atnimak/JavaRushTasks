package com.javarush.task.task14.task1420;

/* 
НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> divisorsForOne = new ArrayList<Integer>();
        ArrayList<Integer> divisorsForTwo = new ArrayList<Integer>();
        int one;
        int two;
        int NOD;
        one = Integer.parseInt(reader.readLine());
        if(one<=0)throw new Exception();
        two = Integer.parseInt(reader.readLine());
        if(two<=0)throw new Exception();
        //находим все делители для числа один
        for (int i = 1; i < one + 1; i++) {
            if (one % i == 0) {
                divisorsForOne.add(i);
            }
        }
        //находим все делители для числа два
        for (int i = 1; i < two + 1; i++) {
            if (two % i == 0) {
                divisorsForTwo.add(i);
            }
        }
        //System.out.println(divisorsForOne);
        //System.out.println(divisorsForTwo);

        NOD = findNOD(divisorsForOne, divisorsForTwo);
        System.out.println(NOD);
    }

    static int findNOD(ArrayList<Integer> divisorsForOne, ArrayList<Integer> divisorsForTwo) {
        for (int i = divisorsForOne.size() - 1; i >= 0; i--) {
            for (int j = divisorsForTwo.size() - 1; j >= 0; j--) {
                if (divisorsForOne.get(i) == divisorsForTwo.get(j)) {
                    return divisorsForOne.get(i);
                }
            }
        }
        return 1;
    }
}
