package com.javarush.task.task25.task2512;

import java.util.ArrayList;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        ArrayList<Throwable> throwables = new ArrayList<>();
        Throwable exception = e;
        while(exception!=null){
            throwables.add(0,exception);
            exception = exception.getCause();
        }

        for(Throwable causeofexception: throwables){
            System.out.println(causeofexception);
        }

    }

    public static void main(String[] args) {
    }
}
