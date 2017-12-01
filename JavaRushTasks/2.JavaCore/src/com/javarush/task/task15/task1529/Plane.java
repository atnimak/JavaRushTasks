package com.javarush.task.task15.task1529;

/**
 * Created by Maxim on 22.03.2017.
 */
public class Plane implements Flyable {
    int passagers;

    Plane(int passagers){
        this.passagers = passagers;
    }

    @Override
    public void fly() {

    }
}
