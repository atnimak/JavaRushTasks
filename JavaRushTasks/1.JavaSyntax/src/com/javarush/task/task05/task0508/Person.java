package com.javarush.task.task05.task0508;

/* 
Геттеры и сеттеры для класса Person
Геттеры и сеттеры для класса Person
Создать class Person. У человека должно быть имя String name, возраст int age, пол char sex.
Создайте геттеры и сеттеры для всех переменных класса Person.
*/

public class Person {
    //напишите тут ваш код
    String name;
    int age;
    char sex;

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public static void main(String[] args) {

    }
}
