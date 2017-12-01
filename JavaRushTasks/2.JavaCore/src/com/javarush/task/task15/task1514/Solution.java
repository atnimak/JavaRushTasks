package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики 1
В статическом блоке инициализировать labels 5 различными парами ключ-значение.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static
    {
        labels.put(5.0,"Mother");
        labels.put(6.0,"Mother");
        labels.put(7.0,"Mother");
        labels.put(8.0,"Mother");
        labels.put(9.0,"Mother");


    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
