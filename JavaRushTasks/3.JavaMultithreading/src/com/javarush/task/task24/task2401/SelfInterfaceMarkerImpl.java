package com.javarush.task.task24.task2401;

/**
 * Created by Maxim on 08.08.2017.
 */
public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker {

    public void print(){
        System.out.println("Printing!");
    }

    public String getString(){
        return "Get it!";
    }
}
