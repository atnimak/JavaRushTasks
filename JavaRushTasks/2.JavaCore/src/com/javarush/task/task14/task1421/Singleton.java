package com.javarush.task.task14.task1421;

public class Singleton {
    private Singleton() {}

    private static Singleton instance;

    public static  Singleton getInstance(){
        if(instance==null){
            instance = new Singleton();
        }

        return instance;
    }
}


/*public class Singleton {
    private Singleton() {}

    private static final Singleton instanse = new Singleton();

    public static Singleton getInstance(){
        return instanse;
    }
}*/
