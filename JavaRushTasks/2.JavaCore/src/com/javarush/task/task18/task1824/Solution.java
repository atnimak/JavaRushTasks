package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args)  {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = null;

        do {
            try {
                filename = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(filename));
                inputStream.close();
            } catch (FileNotFoundException e) {

                System.out.println(filename);
                break;

            } catch (IOException e) {
                e.printStackTrace();
            }


        }while(true);
    }
}
