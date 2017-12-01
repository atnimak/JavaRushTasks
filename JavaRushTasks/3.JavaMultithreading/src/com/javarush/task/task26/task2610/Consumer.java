package com.javarush.task.task26.task2610;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Maxim on 12.09.2017.
 */
public class Consumer implements Runnable {
    private BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
    this.queue = queue;
    }

    @Override
    public void run() {
        try{

            while(true){
                System.out.println(String .valueOf(queue.take()));
            }
        }catch (Exception e){
        }

    }
}
