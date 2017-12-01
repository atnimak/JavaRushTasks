package com.javarush.task.task26.task2603;

import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static class CustomizedComparator<T> implements Comparator<T>{
        private Comparator<T>[] comparators;
        CustomizedComparator(Comparator<T>... comparators){
            this.comparators=comparators;
        }

        @Override
        public int compare(T o1, T o2) {
            int dif =0;
            for(int i=0;i<comparators.length;i++){
                dif =  comparators[i].compare(o1,o2);
                if(dif!=0) break;
            }
            return dif;

        }
    }

    public static void main(String[] args) {

    }
}
