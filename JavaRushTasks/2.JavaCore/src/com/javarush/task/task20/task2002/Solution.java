package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }
    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println("<newObject>");
            printWriter.println(users.size());
            if(users.size()>0){
                for(User u:users){
                    //printWriter.println(u);
                    printWriter.println(u.getFirstName());
                    printWriter.println(u.getLastName());
                    long dat = u.getBirthDate().getTime();
                    printWriter.println(dat);
                    printWriter.println(u.isMale());
                    printWriter.println(u.getCountry());
                }
            }

            printWriter.flush();
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line=fileReader.readLine())!=null) {
                if (line.equals("<newObject>")) {
                    int size = Integer.parseInt(fileReader.readLine());
                    for (int i = 0; i < size; i++) {
                        User user = new User();
                        user.setFirstName(fileReader.readLine());
                        user.setLastName(fileReader.readLine());
                        String s = fileReader.readLine();
                        long dar = Long.parseLong(s);
                        Date bd0 = new Date();
                        bd0.setTime(dar);
                        Date bd=bd0;
                        user.setBirthDate(bd);
                        user.setMale(Boolean.parseBoolean(fileReader.readLine()));
                        user.setCountry(User.Country.valueOf(fileReader.readLine()));

                        users.add(user);
                    }
                }


            }

            fileReader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
