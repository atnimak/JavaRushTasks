package com.javarush.task.task22.task2203;

/* 
Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.


Требования:
1. Класс TooShortStringException должен быть потомком класса Exception.
2. Метод getPartOfString должен принимать строку в качестве параметра.
3. В случае, если строка, переданная в метод getPartOfString содержит менее 2 табуляций должно возникнуть исключение TooShortStringException.
4. Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if((string==null)||(string.equals(""))||(string.isEmpty())||(!(string.contains("\t")))){
            throw new TooShortStringException();
        }



        char[] chars = string.toCharArray();

        int tmp = 0;
        for(int t = 0;t<chars.length;t++){
            if(String.valueOf(chars[t]).equals("\t"))tmp++;
        }
        if(tmp<2)throw  new TooShortStringException();

       /*
        //Элегантное решение вместо цикла
        String[] s = string.split("\t");
        return s[1];*/

        int first = string.indexOf("\t")+1;
        int second=0;
        int secondindex=0;
        for(int i = 0;i<chars.length;i++){
            if(String.valueOf(chars[i]).equals("\t")){
                secondindex++;
                if(secondindex==2){
                    second=i;
                    break;
                }
            }
        }

        String s = string.substring(first,second);

        return s;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString(" \tJavaRush - лучший сервис \tобучения Java\t."));//"\tJavaRush - лучший сервис \tобучения Java\t."
    }
}
