package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Maxim on 12.09.2017.
 */
public class Producer implements  Runnable{

    private ConcurrentHashMap<String, String> map;


    public Producer(ConcurrentHashMap<String, String> map) {
    this.map = map;
    }

    @Override
    public void run() {
       try{


        for(int i = 1;true;i++){
            map.put(String.valueOf(i),"Some text for "+i);
            Thread.sleep(500);
        }
       }catch (Exception e){
           //[TREAD_NAME] thread was terminated«, пример «[thread-1] thread was terminated
           System.out.println(String.format("[%s] thread was terminated",Thread.currentThread().getName()));
       }
    }
}
