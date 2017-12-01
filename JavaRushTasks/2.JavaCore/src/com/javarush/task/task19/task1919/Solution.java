package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] — String, [значение] — double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени.
Закрыть потоки.

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль каждое имя и сумму всех его значений, все данные должны быть отсортированы в возрастающем порядке по имени.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String,Double> map = new TreeMap<>();

        String filename = args[0];
        BufferedReader filereader = new BufferedReader(new FileReader(filename));

        while (filereader.ready()){
            String data = filereader.readLine();
            String[] strings = data.split(" ");
            String name = strings[0];
            double number = Double.parseDouble(strings[1]);

            if(map.containsKey(name)){
                double sum = map.get(name) + number;
                map.put(name,sum);
            }else{
                map.put(name,number);
            }

        }
        filereader.close();

        for(Map.Entry<String,Double> pair:map.entrySet()){
            System.out.println(pair.getKey()+" "+pair.getValue());
        }

    }
}
