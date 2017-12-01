package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {

    AmigoOutputStream original;

    public QuestionFileOutputStream(AmigoOutputStream amigo) {
       this.original = amigo;
    }

    @Override
    public void flush() throws IOException {
      original.flush();
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
        original.write(b,off,len);
    }

    @Override
    public void close() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        String confirm = reader.readLine();
        if(confirm.equals("Д")){
            reader.close();
            original.close();
        }


    }
}

