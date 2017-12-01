package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

/* 
Десериализация JSON объекта
*/
public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
       /* BufferedReader reader = new BufferedReader(new FileReader(fileName));
        StringBuffer jsonString= new StringBuffer();
        while(reader.ready()){
            jsonString.append(reader.readLine());
        }

        StringReader stringReader = new StringReader(jsonString.toString());
        ObjectMapper mapper = new ObjectMapper();
        T object = mapper.readValue(stringReader,clazz);*/
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new FileReader(new File(fileName)), clazz);
    }

    public static void main(String[] args) {

    }
}
