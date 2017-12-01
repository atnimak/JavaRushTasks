package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;
        public PersonScannerAdapter(Scanner scanner){
            this.fileScanner = scanner;
        }


        @Override
        public Person read() throws IOException {
            String[] data = fileScanner.nextLine().split(" ");
            Date date = new GregorianCalendar(Integer.parseInt(data[5]),Integer.parseInt(data[4])-1,Integer.parseInt(data[3])).getTime();
            return new Person(data[1],data[2],data[0],date);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();

        }
    }
}
