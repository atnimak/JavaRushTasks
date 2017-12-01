package com.javarush.task.task17.task1711;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        SimpleDateFormat formDateIn = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
        SimpleDateFormat formDateOut = new SimpleDateFormat("dd-MMM-yyyy" , Locale.ENGLISH);
        int size = args.length;

        switch (args[0]){
            case "-c":
                synchronized (allPeople){
                    for(int i = 1;i<size;){
                        if (args[i+1].equals("м"))  allPeople.add(Person.createMale(args[i], formDateIn.parse(args[i+2])));
                        else if (args[i+1].equals("ж"))   allPeople.add(Person.createFemale(args[i],formDateIn.parse(args[i+2])));
                        System.out.println(allPeople.size() - 1);
                        i=i+3;
                    }
                    break;
                }


            case "-u":
                synchronized (allPeople){
                    for(int i = 1;i<size;){

                        allPeople.get(Integer.parseInt(args[i])).setName(args[i+1]);
                        if (args[i+2].equals("м")) allPeople.get(Integer.parseInt(args[i])).setSex(Sex.MALE);
                        else if (args[i+2].equals("ж")) allPeople.get(Integer.parseInt(args[i])).setSex(Sex.FEMALE);
                        allPeople.get(Integer.parseInt(args[i])).setBirthDay(formDateIn.parse(args[i+3]));
                        i=i+4;
                    }
                    break;
                }

            case "-d":
                synchronized (allPeople){
                    for(int i = 1;i<size;i++) {
                        allPeople.get(Integer.parseInt(args[i])).setName(null);
                        allPeople.get(Integer.parseInt(args[i])).setSex(null);
                        allPeople.get(Integer.parseInt(args[i])).setBirthDay(null);
                    }
                    break;
                }

            case "-i":
                synchronized (allPeople){
                for(int i = 1;i<size;i++) {
                    String sex = allPeople.get(Integer.parseInt(args[i])).getSex().equals(Sex.MALE) ? "м" : "ж";
                    System.out.println(allPeople.get(Integer.parseInt(args[i])).getName() + " "
                            + sex + " "
                            + formDateOut.format(allPeople.get(Integer.parseInt(args[i])).getBirthDay()));
                }
                    break;
            }



        }
      /*  if (args[0].equals("-c")) {
            synchronized (allPeople){
                for(int i = 1;i<size;){
                    if (args[i+1].equals("м"))  allPeople.add(Person.createMale(args[i], formDateIn.parse(args[i+2])));
                    else if (args[i+1].equals("ж"))   allPeople.add(Person.createFemale(args[i],formDateIn.parse(args[i+2])));
                    System.out.println(allPeople.size() - 1);
                    i=i+3;
                }
            }
        }
        else if (args[0].equals("-u")) {
            synchronized (allPeople){
                for(int i = 1;i<size;){

                    allPeople.get(Integer.parseInt(args[i])).setName(args[i+1]);
                    if (args[i+2].equals("м")) allPeople.get(Integer.parseInt(args[i])).setSex(Sex.MALE);
                    else if (args[i+2].equals("ж")) allPeople.get(Integer.parseInt(args[i])).setSex(Sex.FEMALE);
                    allPeople.get(Integer.parseInt(args[i])).setBirthDay(formDateIn.parse(args[i+3]));
                    i=i+4;
                }
            }
        }
        else if (args[0].equals("-d")) {
            synchronized (allPeople){
                for(int i = 1;i<size;i++) {
                    allPeople.get(Integer.parseInt(args[i])).setName(null);
                    allPeople.get(Integer.parseInt(args[i])).setSex(null);
                    allPeople.get(Integer.parseInt(args[i])).setBirthDay(null);
                }
            }
        }
        else if (args[0].equals("-i")) {
            synchronized (allPeople){
                for(int i = 1;i<size;i++) {
                    String sex = allPeople.get(Integer.parseInt(args[i])).getSex().equals(Sex.MALE) ? "м" : "ж";
                    System.out.println(allPeople.get(Integer.parseInt(args[i])).getName() + " "
                            + sex + " "
                            + formDateOut.format(allPeople.get(Integer.parseInt(args[i])).getBirthDay()));
                }
            }
        }*/
    }
}
