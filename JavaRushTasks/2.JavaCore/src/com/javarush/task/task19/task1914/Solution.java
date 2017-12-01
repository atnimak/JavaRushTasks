package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleString = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        System.setOut(consoleString);
        String resulting = outputStream.toString();
        String[] mas = resulting.split(" ");
        int first = Integer.parseInt(mas[0]);
        int second = Integer.parseInt(mas[2]);
        int res = 0;
        if(mas[1].equals("+")){
            res = first+second;
        }else if(mas[1].equals("-")){
            res = first-second;

        }else if(mas[1].equals("*")){
            res = first*second;
        }
        resulting = mas[0]+" "+mas[1]+" "+mas[2]+" "+mas[3]+" "+res;



        System.out.println(resulting);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

