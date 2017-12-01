package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
Сформируй часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.

Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}

Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"


Требования:
1. Метод getQuery должен принимать один параметр типа Map.
2. Метод getQuery должен иметь тип возвращаемого значения String.
3. Метод getQuery должен быть статическим.
4. Метод getQuery должен возвращать строку сформированную по правилам описанным в условии задачи.
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "Ivanov");
        map.put("country", "Ukrain");
        map.put("age", null);
        System.out.println(getQuery(map));

    }
   public static String getQuery(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();
        for(Map.Entry<String,String> pair:params.entrySet()){
            String key = pair.getKey();
            String value = pair.getValue();
            if(!(value==null)){
                if(!stringBuilder.toString().equals("")){
                    stringBuilder.append(" and ");
                }
                stringBuilder.append(key+" = ").append("\'" +value+"\'");
            }
        }
        return stringBuilder.toString();
    }
}
