package com.javarush.task.task24.task2409;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static com.javarush.task.task24.task2409.Util.Company.Levis;

public class Util {
    protected static Collection<Object[]> jeansArray = new LinkedList<>();

    static {
        jeansArray.add(new Object[]{1, Levis, 34, 6, 150.0});
        jeansArray.add(new Object[]{2, Company.Denim, 35, 8, 154.0});
        jeansArray.add(new Object[]{3, Company.Colins, 32, 6, 120.0});
        jeansArray.add(new Object[]{4, Company.CalvinKleinJeans, 31, 8, 125.0});
    }

    public static List<Jeans> getAllJeans() {

        //add your code here
        /*2.2) создай абстрактный class AbstractJeans от интерфейса Jeans с одним абстрактным методом, реализуй остальные методы
          2.3) создай классы Levis и Denim от AbstractJeans, реализуй оставшийся метод
          2.4) в классе AbstractJeans реализуй метод toString() (можешь воспользоваться Alt+Insert -> toString())
          2.5) метод toString класса AbstractJeans должен начинаться с имени сабкласса, например, Levis{id=1, length=34, size=6, price=150.0}*/

        abstract class AbstractJeans implements Jeans{

            AbstractJeans(int id,int length, int size, double price){
                this.id = id;
                this.length = length;
                this.size = size;
                this.price = price;
            }

            protected int id;
            protected int length;
            protected int size;
            protected double price;

            @Override
            public int getId() {
                return id;
            }

            @Override
            public double getPrice() {
                return price;
            }

            @Override
            public abstract String getTM();

            @Override
            public int getLength() {
                return length;
            }

            @Override
            public int getSize() {
                return size;
            }
        }

        class Levis extends AbstractJeans{
            Levis(int id, int length, int size, double price) {
                super(id, length, size, price);
            }

            @Override
            public String getTM() {
                return String.valueOf(Company.Levis);
            }
        }

        class Denim extends AbstractJeans{
            Denim(int id, int length, int size, double price) {
                super(id, length, size, price);
            }

            @Override
            public String getTM() {
                return String.valueOf(Company.Denim);
            }
        }

        List<Jeans> allJeans = new LinkedList<>();

        for (Object[] obj : getJeansArray()) {
            int id = (int) obj[0];
            final Company company = (Company ) obj[1];
            int length = (int) obj[2];
            int size = (int) obj[3];
            double price = (double) obj[4];

            Jeans jeans = null;
            if (Levis == company) {
                jeans = new Levis(id, length, size, price);
            } else
                if (Company.Denim == company) {
                    jeans = new Denim(id, length, size, price);
                } else {
                    jeans = new AbstractJeans(id, length, size, price) {
                        public String getTM() {
                            return company.fullName;
                        }
                    };
                }
            allJeans.add(jeans);
        }
        return allJeans;
    }

    public static Collection<Object[]> getJeansArray() {
        return jeansArray;
    }

    static enum Company {
        Levis ("Levi's"),
        Denim("Denim"),
        Colins("COLIN'S"),
        CalvinKleinJeans("Calvin Klein Jeans");

        final String fullName;
        Company(String name) {
            this.fullName = name;
        }
    }
}
