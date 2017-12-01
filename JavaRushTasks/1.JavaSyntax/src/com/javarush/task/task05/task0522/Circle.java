package com.javarush.task.task05.task0522;

/* 
Максимум конструкторов
Изучи класс Circle. Напиши максимальное количество конструкторов с разными аргументами.

Подсказка:
не забудь про конструктор по умолчанию.
*/

public class Circle {
    public double x;
    public double y;
    public double radius;

    //напишите тут ваш код
   public Circle(){
        this.x = 10;
        this.y = 20;
        this.radius = 30;
    }

    public Circle(double x){
        this.x = x;
        this.y = 20;
        this.radius = 30;
    }

    public Circle(double x, double y){
        this.x = x;
        this.y = y;
        /*this.radius = 30;*/
    }

    public Circle(double x, double y, double radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public static void main(String[] args) {

    }
}