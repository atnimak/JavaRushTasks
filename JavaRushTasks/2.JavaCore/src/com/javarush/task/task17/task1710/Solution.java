package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }
    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        SimpleDateFormat formDateIn = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
        SimpleDateFormat formDateOut = new SimpleDateFormat("dd-MMM-yyyy" , Locale.ENGLISH);
        if (args[0].equals("-c")) {
            if (args[2].equals("м"))  allPeople.add(Person.createMale(args[1], formDateIn.parse(args[3])));
            else if (args[2].equals("ж"))   allPeople.add(Person.createFemale(args[1],formDateIn.parse(args[3])));
            System.out.println(allPeople.size() - 1);
        }
        else if (args[0].equals("-u")) {
            allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
            if (args[3].equals("м")) allPeople.get(Integer.parseInt(args[1])).setSex(Sex.MALE);
            else if (args[3].equals("ж")) allPeople.get(Integer.parseInt(args[1])).setSex(Sex.FEMALE);
            allPeople.get(Integer.parseInt(args[1])).setBirthDay(formDateIn.parse(args[4]));
        }
        else if (args[0].equals("-d")) {
            allPeople.get(Integer.parseInt(args[1])).setName(null);
            allPeople.get(Integer.parseInt(args[1])).setSex(null);
            allPeople.get(Integer.parseInt(args[1])).setBirthDay(null);
        }
        else if (args[0].equals("-i")) {
            String sex = allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.MALE)? "м" : "ж" ;
            System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " "
                    + sex+ " "
                    + formDateOut.format(allPeople.get(Integer.parseInt(args[1])).getBirthDay()));
        }
    }
}
/*
Мое решение. Работает, но не проходит.

package com.javarush.task.task17.task1710;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;
        import java.util.Locale;

*/
/*
CRUD
*//*


public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input=null;
        String parameter=null;
        String name =null;
        String sex = null;
        String bd = null;
        Date tmp = null;
        int index;

        try {
            input = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        parameter = input.substring(0,2);
        //System.out.println(parameter);


        if (parameter.equals("-c")){
            String[] splitInt = input.split(" ");
            name = splitInt[1];
            sex = splitInt[2];

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            try {
                //System.out.println(splitInt[3]);
                tmp = format.parse(splitInt[3]);
                bd = format1.format(tmp);
                //System.out.println();

            } catch (ParseException e) {
                e.printStackTrace();
            }
            Person p = null;

            if(sex.equals("м")){
                p  = Person.createMale(name, tmp);
                allPeople.add(p);  //сегодня родился    id=0
            }else if(sex.equals("ж")){
                p = Person.createFemale(name, tmp);
                allPeople.add(p);  //сегодня родился    id=0

            }
            index = allPeople.indexOf(p);
            System.out.println(index);
            //System.out.println(name+" "+sex+" "+bd);

        }else if(parameter.equals("-u")){
            //System.out.println(allPeople.size());
            String[] splitInt = input.split(" ");
            index = Integer.parseInt(splitInt[1]);
            name = splitInt[2];
            sex = splitInt[3];

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            try {
                //System.out.println(splitInt[3]);
                tmp = format.parse(splitInt[4]);
                bd = format1.format(tmp);
                //System.out.println();

            } catch (ParseException e) {
                e.printStackTrace();
            }

            // Person inputPerson = allPeople.get(index);
            allPeople.get(index).setName(name);

            if(sex.equals("м")){
                allPeople.get(index).setSex(Sex.MALE);
            }else if(sex.equals("ж")){
                allPeople.get(index).setSex(Sex.FEMALE);
            }
            allPeople.get(index).setBirthDay(tmp);

            //System.out.println(allPeople.size());


        }else if(parameter.equals("-d")){
            //System.out.println(allPeople.size());
            String[] splitInt = input.split(" ");
            index = Integer.parseInt(splitInt[1]);

            allPeople.get(index).setName(null);
            allPeople.get(index).setSex(null);
            allPeople.get(index).setBirthDay(null);
            //System.out.println(allPeople.size());

        }else if(parameter.equals("-i")){
            String[] splitInt = input.split(" ");
            index = Integer.parseInt(splitInt[1]);


            Person p = allPeople.get(index);
            Sex sex1 = p.getSex();
            String sex2=null;
            if(sex1.equals(Sex.MALE)){
                sex2 = "м";
            }else if(sex1.equals(Sex.FEMALE)){
                sex2 = "ж";
            }


            SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            bd = format1.format(p.getBirthDay());

            System.out.println(p.getName()+" "+sex2+" "+bd);

        }
    }
}
*/
