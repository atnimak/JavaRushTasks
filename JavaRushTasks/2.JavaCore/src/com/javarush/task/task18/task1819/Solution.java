package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.Arrays;

/*public class Solution {
    public static void main(String[] args) throws IOException {
        String name1,name2;
        byte[] buffer1,buffer2;
        int count1,count2;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  *//*      name1 = reader.readLine();
        name2 = reader.readLine();*//*
        name1 = "poki";
        name2 = "pom";
        reader.close();

        BufferedInputStream file1 = new BufferedInputStream(new FileInputStream(name1));
        BufferedInputStream file2 = new BufferedInputStream(new FileInputStream(name2));
        buffer1 = new byte[file1.available()];
        count1 = file1.read(buffer1);
        buffer2 = new byte[file2.available()];
        count2 = file1.read(buffer2);
        String string2 = new String(buffer2);


       BufferedOutputStream ofile1 = new BufferedOutputStream(new FileOutputStream(name1)) ;
        ofile1.write(string2.getBytes());
        ofile1.write(buffer1);

        file1.close();
        file2.close();
        ofile1.close();




    }
}*/
public class Solution {
    public static void main(String[] args) throws IOException {
        byte[]fb1,fb2;
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
       String f1=reader.readLine(),f2=reader.readLine();
        //String f1="pom",f2="poki";
        reader.close();


        BufferedInputStream file1=new BufferedInputStream(new FileInputStream(f1));
        BufferedInputStream file2=new BufferedInputStream(new FileInputStream(f2));

        fb1=new byte[file1.available()];
        /*System.out.println("Массив один после считывания");
        System.out.println(Arrays.toString(fb1));*/
        fb2=new byte[file2.available()];

        file1.read(fb1);
        file2.read(fb2);
        String s1 = new String(fb1);
/*        System.out.println("Строка 1");
        System.out.println(s1);*/
        String s2 = new String(fb2);
/*        System.out.println("Строка 2");
        System.out.println(s2);*/
        String s3 = s2+s1;
/*        System.out.println("Строка 3");
        System.out.println(s3);*/
        BufferedOutputStream ofile1=new BufferedOutputStream(new FileOutputStream(f1,false));
        ofile1.write(s3.getBytes());


        file2.close();
        file1.close();
        ofile1.close();

    }
}
