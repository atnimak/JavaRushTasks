package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        byte[]fb2,fb3;
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String f1=reader.readLine(),f2=reader.readLine(),f3=reader.readLine();
        //String f1="pom",f2="poki",f3="pip";
        reader.close();

        //BufferedOutputStream file1=new BufferedOutputStream(new FileOutputStream(f1,false));
        BufferedOutputStream file1=new BufferedOutputStream(new FileOutputStream(f1));
        BufferedInputStream file2=new BufferedInputStream(new FileInputStream(f2));
        BufferedInputStream file3=new BufferedInputStream(new FileInputStream(f3));

        fb2=new byte[file2.available()];
        file2.read(fb2);
        file1.write(fb2);
        file2.close();

        fb3=new byte[file3.available()];
        file3.read(fb3);
        file1.write(fb3);

        file3.close();
        file1.close();

    }
}


/*
public class Solution {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        reader.close();

        FileOutputStream file1output = new FileOutputStream(file1);
        FileInputStream file2input = new FileInputStream(file2);
        FileInputStream file3input = new FileInputStream(file3);


        byte[] buffer = new byte[file2input.available()];
        int count = file2input.read(buffer);
        file1output.write(buffer,0,count);
        file2input.close();


        byte[] buffer3 = new byte[file3input.available()];
        int count3 = file3input.read(buffer3);
        file3input.close();
        file1output.write(buffer3,0,count3);
        file1output.close();
    }
}
*/
