package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();
    public static ArrayList<Thread> threadlist = new ArrayList();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filename;
        do{
            filename = reader.readLine();
            if(filename.equals("exit")) break;
            ReadThread thread = new ReadThread(filename);
            thread.start();
            threadlist.add(thread);

        }while(!(filename.equals("exit")));


        reader.close();

    }

    public static class ReadThread extends Thread {
       private String filename;

        public ReadThread(String fileName) {
            this.filename = fileName;//implement constructor body
        }
        // implement file reading here - реализуйте чтение из файла тут


        @Override
        public void run() {
            try {
                FileInputStream inputStream= new FileInputStream(filename);
                byte[] bytes = new byte[128];
                while(inputStream.available()>0){
                    bytes[inputStream.read()]++;

                }

                int max=0;
                int ourbute = 0;
                for(int i=0;i<bytes.length;i++){
                    if(bytes[i]>max){
                        max=bytes[i];
                        ourbute = i;
                    }
                }

                resultMap.put(filename,ourbute);
                inputStream.close();


            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
