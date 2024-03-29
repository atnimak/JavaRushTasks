package com.javarush.task.task19.task1917;

import java.io.*;
import java.nio.charset.Charset;

/* 
Свой FileWriter
*/

public class FileConsoleWriter {
    private FileWriter fileWriter;
    public static void main(String[] args) throws IOException {
        FileConsoleWriter fcw = new FileConsoleWriter("tmp.txt");
        char[] buf = {'a','b','c','d','e'};
        fcw.write(buf,2,2);
        fcw.close();

    }
    public FileConsoleWriter(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        fileWriter = new FileWriter(fd);
    }


    public void write(char[] cbuf, int off, int len) throws IOException{
        String result = new String(cbuf).substring(off, off+len);
        System.out.println(result);
        fileWriter.write(cbuf, off, len);

    }
    public void write(int c) throws IOException{
        System.out.println(c);
        fileWriter.write(c);

    }
    public void write(String str) throws IOException{
        System.out.println(str);
        fileWriter.write(str);
    }
    public void write(String str, int off, int len) throws IOException{
        String result = str.substring(off, off+len);
        System.out.println(result);
        fileWriter.write(str, off, len);
    }
    public void write(char[] cbuf) throws IOException{
        System.out.println(cbuf);
        fileWriter.write(cbuf);

    }
    public void close() throws IOException{
        fileWriter.close();

    }

}
