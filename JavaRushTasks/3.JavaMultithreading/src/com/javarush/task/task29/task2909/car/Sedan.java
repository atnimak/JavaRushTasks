package com.javarush.task.task29.task2909.car;

/**
 * Created by Maxim on 06.09.2017.
 */
public class Sedan extends Car {
    public Sedan(int numberOfPassengers) {
        super(Car.CABRIOLET, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        final int MAX_SEDAN_SPEED = 120;
        return MAX_SEDAN_SPEED;
    }
}
