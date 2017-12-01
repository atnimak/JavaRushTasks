package com.javarush.task.task18.task1809;

/* 
Реверс файла
Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке.
Закрыть потоки.


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файл - FileOutputStream
3. Во второй файл нужно записать все байты из первого в обратном порядке.
4. Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = reader.readLine();
        String secondFile = reader.readLine();

        FileInputStream inputStream1 = new FileInputStream(firstFile);

        FileOutputStream outputStream2 = new FileOutputStream(secondFile);

        byte[] buffer = new byte[inputStream1.available()];

        while(inputStream1.available()>0){
            int count = inputStream1.read(buffer);
        }

        for(int i = buffer.length-1;i>=0;i--){
            outputStream2.write(buffer[i]);
        }


        inputStream1.close();
        outputStream2.close();



    }
}
