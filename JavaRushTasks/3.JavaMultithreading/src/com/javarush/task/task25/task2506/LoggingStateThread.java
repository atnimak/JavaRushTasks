package com.javarush.task.task25.task2506;

/**
 * Created by Maxim on 31.08.2017.
 */
class LoggingStateThread extends Thread{
    Thread target;
    public LoggingStateThread(Thread thread){
        this.target = thread;
        this.setDaemon(true);
    }
    @Override
    public void run(){
        State state = target.getState();
        System.out.println(state);
        do{
            if(state != target.getState()){
                state = target.getState();
                System.out.println(state);
            }
        }while(state!=State.TERMINATED);



    }

}