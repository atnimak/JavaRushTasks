package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/*public class Solution {
    public static void main(String[] args) throws IOException {
 //       FileInputStream inputStream = new FileInputStream("pom");
  FileInputStream inputStream = new FileInputStream(args[0]);
        byte[] buffer = new byte[inputStream.available()];
        if(inputStream.available()>0){
            int count = inputStream.read(buffer);
        }
        int spacecount=0;
        int allcount=0;

        String bufferString = new String(buffer);
        for(int i = 0;i<bufferString.length();i++){
            if(bufferString.substring(i,i+1).equals(" ")){
                spacecount++;
            }else{
                allcount++;
                spacecount++;
            }
        }

        double result =(double)spacecount/(double)allcount*100;
        //result =(double)allcount/((double)spacecount*(double)100);

        String pattern = "##0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String format = decimalFormat.format(result);
        System.out.println(spacecount);
        System.out.println(allcount);
        System.out.println(format);
        inputStream.close();


    }
}*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        int charCount = 0;
        int spaceCount = 0;
        while (fis.available() > 0) {
            int letter = fis.read();
            charCount++;
            if (letter == 32) spaceCount++;
        }
        fis.close();
        double result =(double)spaceCount/(double)charCount*100;
        String pattern = "##0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String format = decimalFormat.format(result);
        System.out.println(format);
    }
}
