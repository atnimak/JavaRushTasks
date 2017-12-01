package com.javarush.task.task08.task0818;

import java.util.*;

/* 
Только для богачей
Создать словарь (Map<String, Integer>) и занести в него десять записей по принципу: «фамилия» — «зарплата».
Удалить из словаря всех людей, у которых зарплата ниже 500.
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //создает и возвращает словарь HashMap с типом элементов String, Integer состоящих из 10 записей по принципу «фамилия» - «зарплата».
        HashMap<String,Integer> namelist = new HashMap<String,Integer>();
        namelist.put("Петров",200);
        namelist.put("Иванов",300);
        namelist.put("Семенов",500);
        namelist.put("Гончаров",600);
        namelist.put("Сергеев",800);
        namelist.put("Петренко",1200);
        namelist.put("Антонов",400);
        namelist.put("Васюков",600);
        namelist.put("Аленов",200);
        namelist.put("Димов",100);
        return namelist;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //создаем список ключей на удаление,ищем ключи, для плохих значений и закидываем их в список
        Collection<String> str = map.keySet();
        ArrayList<String> keysNogood = new ArrayList<String>();
        for(String st:str){
            if(map.get(st)<500)
            keysNogood.add(st);
        }
       // System.out.println(keysNogood);

        //удаляем из namelist все ключи, которые встречаются в списке плохих ключей.
        Iterator<String> iterator2 = keysNogood.iterator();
        while (iterator2.hasNext()){
            String in2 = iterator2.next();
            map.remove(in2);

        }

    }

    public static void main(String[] args) {
       /* HashMap<String,Integer> namelist = createMap();
        System.out.println(namelist);
        removeItemFromMap(namelist);
        System.out.println(namelist);*/

    }
}

