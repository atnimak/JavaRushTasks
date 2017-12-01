package com.javarush.task.task20.task2024;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* 
Знакомство с графами
*/
public class Solution implements Serializable{
    int node;
    List<Solution> edges = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("pom"));
        Solution solution = new Solution();
        outputStream.writeObject(solution);

    }
}
