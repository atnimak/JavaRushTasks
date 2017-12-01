package com.javarush.task.task14.task1419;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.io.*;

/* 
Нашествие исключений
Заполни список exceptions десятью(10) различными исключениями.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            ArrayList list = new ArrayList();
            Object o = list.get(5);
        }catch (Exception e){
            exceptions.add(e);
        }

        try{
            Integer.parseInt("lskdfj;aslkjf");
        }catch (Exception e){
            exceptions.add(e);
        }

        try{
            throw new NotActiveException();
        }catch (Exception e){
            exceptions.add(e);
        }

        try{
            throw new NotSerializableException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try{
            throw new NegativeArraySizeException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try{
            throw new NotSerializableException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try{
            throw new EmptyStackException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try{
            throw new CharConversionException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try{
            throw new SyncFailedException("");
        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

    }
}
