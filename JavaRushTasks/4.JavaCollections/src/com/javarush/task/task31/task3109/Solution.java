package com.javarush.task.task31.task3109;

import java.io.*;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
       Properties properties = new Properties();
       File propertyFile = new File(fileName);

        try(InputStream stream = new FileInputStream(fileName)) {
            if(propertyFile.exists()&&propertyFile.isFile()){
                if(propertyFile.getName().endsWith(".xml")){
                    properties.loadFromXML(stream);
                }else{
                   properties.load(stream);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return properties;
    }
}
