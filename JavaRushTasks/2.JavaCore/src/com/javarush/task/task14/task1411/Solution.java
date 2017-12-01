package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
User, Looser, Coder and Proger
1. Ввести [в цикле] с клавиатуры несколько строк (ключей).
Строки(ключи) могут быть такими: «user«, «loser«, «coder«, «proger«.
Ввод окончен, когда строка не совпадает ни с одной из выше указанных.

2. Для каждой введенной строки нужно:
2.1. Создать соответствующий объект [см. Person.java], например, для строки «user» нужно создать объект класса User.
2.2. Передать этот объект в метод doWork.

3. Написать реализацию метода doWork, который:
3.1. Вызывает метод live() у переданного обекта, если этот объект (person) имеет тип User.
3.2. Вызывает метод doNothing(), если person имеет тип Loser.
3.3. Вызывает метод coding(), если person имеет тип Coder.
3.4. Вызывает метод enjoy(), если person имеет тип Proger.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        Person person = null;
        String key = null;

        //тут цикл по чтению ключей, пункт 1
        while(true){
           key = reader.readLine();
           list.add(key);
           if(!((key.equals("user"))||(key.equals("loser"))||(key.equals("coder"))||(key.equals("proger")))){
               list.remove(list.size()-1);
               break;
           }
        }

        //создаем объект, пункт 2 и передаем его в метод doWork();
        for (String s: list) {
            if(s.equals("user")){
                person = new Person.User();
                doWork(person);
            }else if(s.equals("loser")){
                person = new Person.Loser();
                doWork(person);
            }else if(s.equals("coder")){
                person = new Person.Coder();
                doWork(person);
            }else if(s.equals("proger")){
                person = new Person.Proger();
                doWork(person);
            }
        }

       /* {
            //создаем объект, пункт 2

            doWork(person); //вызываем doWork

        }*/
    }

    public static void doWork(Person person) {
        // пункт 3
        if(person instanceof Person.User){
            ((Person.User) person).live();
        }else if(person instanceof Person.Loser){
            ((Person.Loser) person).doNothing();
        }else if(person instanceof Person.Coder){
            ((Person.Coder) person).coding();
        }else if(person instanceof Person.Proger){
            ((Person.Proger) person).enjoy();
        }
    }
}
