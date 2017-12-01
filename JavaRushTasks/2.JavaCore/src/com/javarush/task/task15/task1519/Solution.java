package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

/* 
Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово «exit«.
2. Для каждого значения, кроме «exit«, вызвать метод print. Если значение:
2.1. содержит точку ‘.‘, то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. меньше или равно 0 или больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

public class Solution {

   //Способ решения прошедший проверку. Выводит на консоль ответы после того, как соберет все данные с консоли. Работает через ArrayList.
    /*public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> wordList = new ArrayList<>();
        String stop = "exit";
        String word;
        while(true){
            word = reader.readLine();
            wordList.add(word);
            if(word.equals(stop)){
                wordList.remove(wordList.size()-1);
                break;
            }
        }

        for(int i = 0;i<wordList.size();i++){
            String data = wordList.get(i);
            if(isDouble(data)){
                print(Double.parseDouble(data));
            }else if(isShort(data)){
                print(Short.parseShort(data));
            }else if(isInteger(data)){
                print(Integer.parseInt(data));
            }else{
                print(data);
            }
        }
    }*/

    //Способ, не проверялся на валидаторе, но скорее всего тоже сработает. Выводит ответ сразу. После чего можно еще раз ввести данные.
    //Не использует  список или массив.
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String stop = "exit";
        String data;
        while(true){
            data = reader.readLine();
            if(data.equals(stop)){
                break;
            }

            if(isDouble(data)){
                print(Double.parseDouble(data));
            }else if(isShort(data)){
                print(Short.parseShort(data));
            }else if(isInteger(data)){
                print(Integer.parseInt(data));
            }else{
                print(data);
            }
        }

    }

    //методы isDouble и остальные, а также все перегруженные методы print актуальны для обоих версий main.

    static boolean isDouble(String s){
        if (s.contains(".")){
            try{
               Double d1 = Double.parseDouble(s);
               return true;
            }catch (NumberFormatException e){
                return false;
            }
        }else {
            return false;
        }



    }

    private static boolean isShort(String s){
        short s1;
        try{
                s1 = Short.parseShort(s);
            }catch (NumberFormatException e){
                return false;
            }

        if (s1>0&&s1<128){
            return true;
        }else{
            return false;
        }
    }

    private static boolean isInteger(String s){
        int int1;
        try{
            int1 = Integer.parseInt(s);
        }catch (NumberFormatException e){
            return false;
        }

            if (int1 >= 128 | int1 <= 0){
            return true;
        }else{
            return false;
        }

    }


    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
