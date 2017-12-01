package com.javarush.task.task18.task1808;

/* 
Разделение файла
Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.


Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файлы - FileOutputStream
3. Первую половину байт из первого файла нужно записать во второй файл.
4. Вторую половину байт из первого файла нужно записать в третий файл.
5. Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileFirst = reader.readLine();
        String fileSecond = reader.readLine();
        String fileThird = reader.readLine();

        FileInputStream file1 = new FileInputStream(fileFirst);
        FileOutputStream file2 = new FileOutputStream(fileSecond);
        FileOutputStream file3 = new FileOutputStream(fileThird);

       // int length = inputStream.available();
        if(file1.available() % 2 == 0){
            byte[] o1 = new byte[file1.available()/2];
            byte[] o2 = new byte[file1.available()/2];
            int count1 = file1.read(o1);
            int count2 = file1.read(o2);
            file2.write(o1, 0, count1);
            file3.write(o2, 0, count2);
        } else {
            byte[] o1 = new byte[file1.available()/2 + 1];
            byte[] o2 = new byte[file1.available()/2];
            int count1 = file1.read(o1);
            int count2 = file1.read(o2);
            file2.write(o1, 0, count1);
            file3.write(o2, 0, count2);
        }
        file1.close();
        file2.close();
        file3.close();

    }
}
