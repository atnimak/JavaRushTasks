package com.javarush.task.task29.task2907;

import java.math.BigDecimal;

/* 
Этот странный BigDecimal
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getValue(1.1d, 1.2d));
    }

    public static BigDecimal getValue(double v1, double v2) {
        BigDecimal cash = new BigDecimal(Double.toString(v2));
        BigDecimal anotherCash = new BigDecimal(Double.toString(v1));
        BigDecimal result = anotherCash.add(cash);
        return result;
    }
}