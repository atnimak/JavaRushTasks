package com.javarush.task.task18.task1825;

/* 
Собираем файл
Собираем файл из кусочков.
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.

Например, Lion.avi.part1, Lion.avi.part2, …, Lion.avi.part37.

Имена файлов подаются в произвольном порядке. Ввод заканчивается словом «end«.
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].

Например, Lion.avi.

В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, …, в конце — последнюю.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "end".
2. Создай поток для записи в файл без суффикса [.partN] в папке, где находятся все считанные файлы.
3. В новый файл перепиши все байты из файлов-частей *.partN.
4. Чтение и запись должны происходить с использованием буфера.
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<Integer,String> filenames = new TreeMap<>();
        String nameOfbigFile = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename;
        while(true){
            filename = reader.readLine();
            if(filename.equals("end")){
                break;
            }
            String[] strings = filename.split("\\.");
            //System.out.println(Arrays.toString(strings));


            String part = strings[(strings.length-1)];
            nameOfbigFile = strings[0]+"."+strings[1];
            int numofpart = Integer.parseInt(part.substring(part.length()-1,part.length()));
            filenames.put(numofpart,filename);

        }
        reader.close();

        //System.out.println(nameOfbigFile);
        File bigFile = new File(nameOfbigFile);
        for (Map.Entry<Integer, String> pair : filenames.entrySet())
        {
            Integer key = pair.getKey();                      //ключ
            String value = pair.getValue();                  //значение
           // System.out.println(key + ":" + value);
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(value));
            byte[] inbytes = new byte[inputStream.available()];
            int count = inputStream.read(inbytes);
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(bigFile,true));
            outputStream.write(inbytes,0,count);
            inputStream.close();
            outputStream.close();

            
        }


    }
}
