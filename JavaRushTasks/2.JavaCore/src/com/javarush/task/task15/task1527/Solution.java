package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* 
Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) — для чисел (дробные числа разделяются точкой)
alert(String value) — для строк
Обрати внимание на то, что метод alert необходимо вызывать ПОСЛЕ вывода списка всех параметров на экран.

Пример 1

Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo

Вывод:
lvl view name

Пример 2

Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo

Вывод:
obj name
double 3.14
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here

        //вводим ссылку
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String s = reader.readLine();
        //String s = "http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo";
        String s = "javarush.ru/alpha/index.html?lvl=15&view&name=Aobjmigo&obj=3.14&name=&obj=djsdcd&oobj=3.0&obj=1&obj=2.3&obj=aaa";

        //проверяем, если ссылка не пустая
        if(!s.isEmpty()){

            //отсекаем все ненужное до ? включительно.
            int startIndex = (s.indexOf("?"))+1;
            char[] chars = s.toCharArray();
            String s1=null;

            for(int i = startIndex;i<chars.length;i++){
              if(i==startIndex){
                  s1 = Character.toString(chars[i]);
              }else {
                  s1 += Character.toString(chars[i]);
              }

            }

            //формируем два списка - спискок имен параметров и список параметров
            ArrayList<String> stringArrayList = new ArrayList<>();
            ArrayList<String> nameofparametersarray = new ArrayList<>();
            ArrayList<String> parametersarray = new ArrayList<>();
            ArrayList<String> objessarray = new ArrayList<>();

            //сначала создаем один общий список строк убирая разделители &
            StringTokenizer st = new StringTokenizer(s1,"&");
            while(st.hasMoreTokens()){
                stringArrayList.add(st.nextToken());
            }

            //заносим имена параметров в список имен параметров, а значения параметров в список значений параметров
            char[] nameofparameter;
            char[] parameter;
            char[] objes;
            for(int i = 0;i<stringArrayList.size();i++){
                String data = stringArrayList.get(i);

              if(data.contains("=")){
                  int one = 0;
                  int end = data.indexOf("=");
                  nameofparameter = new char[end - one];
                  data.getChars(one,end,nameofparameter,0);

                  String fromChar = new String(nameofparameter);

                   //если есть параметр obj, создаем список его значений
                  if(fromChar.equals("obj")){
                      int onepobj = end+1;
                      int endobj = data.length();
                      objes = new char[endobj-onepobj];
                      data.getChars(onepobj,endobj,objes,0);
                      String fromCharsObjes = new String(objes);
                      if(!(fromCharsObjes.isEmpty())&(!(fromCharsObjes.equals(" ")))&(!(fromCharsObjes.equals("")))){
                          objessarray.add(fromCharsObjes);
                      }

                  }
                  nameofparametersarray.add(fromChar);

                  int onep = end+1;
                  int endp = data.length();
                  parameter = new char[endp-onep];
                  data.getChars(onep,endp,parameter,0);
                  String fromChar2 = new String(parameter);

                  if(!(fromChar2.isEmpty())&(!(fromChar2.equals(" ")))&(!(fromChar2.equals("")))){
                      parametersarray.add(fromChar2);
                  }

                }else{
                  if(!(data.isEmpty())&(!(data.equals(" ")))&(!(data.equals("")))){
                      nameofparametersarray.add(data);
                  }

              }


            }

            for(int o = 0;o<nameofparametersarray.size();o++){
                System.out.print(nameofparametersarray.get(o)+" ");
            }
           System.out.println("");

            for(int o2 = 0;o2<objessarray.size();o2++){
                 try {
                     double doub = Double.parseDouble(objessarray.get(o2));
                     alert(doub);
                 }catch (Exception e){
                     alert(objessarray.get(o2));
                 }
            }

    }
    }


    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}

