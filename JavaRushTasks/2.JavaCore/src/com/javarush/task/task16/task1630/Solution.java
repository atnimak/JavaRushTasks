package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    //add your code here - добавьте код тут
    //2 пункт
    static {
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader1.readLine();
            secondFileName = reader1.readLine();
            reader1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
      /*  firstFileName = "pom";
        secondFileName = "poki";*/
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        //4.1 пункт
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    //3 пункт
    public static class ReadFileThread extends Thread implements ReadFileInterface{
        BufferedReader reader;


        StringBuilder builder = new StringBuilder();
        //3.1 пункт
        public void setFileName(String fullFileName){
            try {
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(fullFileName)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        //3.2 пункт
        public String getFileContent(){
            try {
                return builder.toString().trim();
            } catch (NullPointerException e) {
                System.out.println(e);
                return null;
            }
        }
        //3.3 пункт
        public void run(){
            String str;

            try {
                while ((str = reader.readLine()) != null) {
                    if (str.trim().length() != 0 ) {
                        builder.append(str.trim() + " ");
                    }
                }
                reader.close();
            } catch (IOException e) {}
        }
    }
}




/*public class Solution {
    public static String firstFileName;
    public static String secondFileName;


    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

       *//* try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }*//*
firstFileName = "pom";
        secondFileName = "poki";

    }


    //add your code here - добавьте код тут

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread implements Runnable, ReadFileInterface{
        ArrayList<String> list = new ArrayList<String>();

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new FileReader(firstFileName));
                String line;
                while ((line = in.readLine()) != null) {
                    // System.out.println(line);
                    list.add(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void setFileName(String fullFileName) {
            firstFileName = fullFileName;

        }

        @Override
        public String getFileContent() {
            String s = "";
            for(int i = 0;i<list.size();i++){
                if(s.isEmpty()){
                    //s=list.get(i)+"\n";
                    s=list.get(i);
                }else{
                    //s += list.get(i)+"\n";
                    s+=list.get(i);
                }

            }
            return s;
        }

        @Override
        public void join() throws InterruptedException {
            Thread.currentThread().join();

        }

        @Override
        public void start() {
            run();

        }
    }
}*/