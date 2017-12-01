package com.javarush.task.task15.task1516;

/* 
Значения по-умолчанию
1. Создать 7 public полей класса. Убедитесь, что они инициализируются дефолтными значениями.
intVar типа int
doubleVar типа double
DoubleVar типа Double
booleanVar типа boolean
ObjectVar типа Object
ExceptionVar типа Exception
StringVar типа String
2. В методе main вывести их значения в заданном порядке.
*/

public class Solution {


     int intVar;
    double doubleVar;
    Double DoubleVar;
    boolean booleanVar;
    Object ObjectVar;
    Exception ExceptionVar;
    String StringVar;

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intVar+" "+solution.doubleVar+" "+solution.DoubleVar+" "+solution.booleanVar+" "+solution.ObjectVar+" "+solution.ExceptionVar+" "+solution.StringVar);
    }
}
