package com.javarush.task.task18.task1810;

/* 
DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки работы с файлами.
2.2 Выбросить исключение DownloadException.


Требования:
1. Программа должна считать имена файлов с консоли.
2. Для чтения из файлов используй поток FileInputStream.
3. Программа должна работать, пока введенный файл не окажется меньше 1000 байт.
4. Программа должна завершиться исключением DownloadException.
5. Поток FileInputStream должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String filename = reader.readLine();
            FileInputStream stream = new FileInputStream(filename);
            int size = stream.available();

            stream.close();
            if (size < 1000)
            {
                reader.close();
                throw new DownloadException();
            }
        }





    /*
    //валидатор принял, но этто говно.
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream;
        File file;
        do{
            String filename = reader.readLine();
           inputStream = new FileInputStream(filename);
            inputStream.close();
            file = new File(filename);
            long size = file.length();
            boolean bo = size<(long)1000;




            if(bo){
                reader.close();

                Thread.sleep(5000);
                Exception ex = new DownloadException();
                throw ex;
            }

        }while(true);*/




    }

    public static class DownloadException extends Exception {

    }
}
