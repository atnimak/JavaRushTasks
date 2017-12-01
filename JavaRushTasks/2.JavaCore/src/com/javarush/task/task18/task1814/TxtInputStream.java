package com.javarush.task.task18.task1814;

import java.io.*;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {
    private String fileName;

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException, InterruptedException {
        super(fileName);
        if(!(fileName.substring(fileName.length()-4).contains(".txt"))){
            super.close();
            Thread.sleep(5000);
            throw new UnsupportedFileNameException();
        }
    }

    public static void main(String[] args) throws IOException, UnsupportedFileNameException {
        //TxtInputStream one = new TxtInputStream("pom.zip");
        //TxtInputStream two = new TxtInputStream("pom");
    }
}

