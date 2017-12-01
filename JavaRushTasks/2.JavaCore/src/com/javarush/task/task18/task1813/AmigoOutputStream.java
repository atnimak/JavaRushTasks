package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream original;

    public AmigoOutputStream(FileOutputStream stream) throws FileNotFoundException {
        super(fileName);
        this.original = stream;
    }

    @Override
    public void write(int b) throws IOException {
        original.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        original.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        original.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        flush();
        write("JavaRush © All rights reserved.".getBytes());
        original.close();
    }

    @Override
    public void flush() throws IOException {
        original.flush();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}

/*
public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream outFile;


    public AmigoOutputStream(FileOutputStream outFile) throws FileNotFoundException, IOException {
        super(fileName);
        this.outFile = outFile;
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        outFile.write(b, off, len);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void write(byte[] b) throws IOException {
        outFile.write(b);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    protected void finalize() throws IOException {
        super.finalize();    //To change body of overridden methods use File | Settings | File Templates.
    }


    @Override
    public void write(int b) throws IOException {
        outFile.write(b);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void flush() throws IOException {
        outFile.flush();
    }

    public void close() throws IOException {
        outFile.flush();
        outFile.write("JavaRush © All rights reserved.".getBytes());
        outFile.close();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }
}*/
