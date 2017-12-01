package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxim on 31.05.2017.
 */
public class Hippodrome {
    public static void main(String[] args){

        game = new Hippodrome(new ArrayList<Horse>());
        game.getHorses().add(new Horse("Maria",3,0));
        game.getHorses().add(new Horse("Sofia",3,0));
        game.getHorses().add(new Horse("Anna",3,0));
        game.run();
        game.printWinner();



    }
    static Hippodrome game;

    private List<Horse> horses;

    public List<Horse> getHorses(){
        return horses;
    }

    public Hippodrome(List<Horse> horses){
        this.horses = horses;

    }

    void run(){
        for(int i = 0;i<100;i++){
            move();
            print();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    void move(){
        for(int i = 0;i<horses.size();i++){
            horses.get(i).move();
        }
    }

    void  print(){
        for(int i = 0;i<horses.size();i++){
            horses.get(i).print();
        }
        for(int j = 0;j<10;j++){
            System.out.println();
        }
    }

    Horse getWinner(){
        double distanse=0;
        Horse winner = null;
        for(int i = 0;i<horses.size();i++){
            if(horses.get(i).distance>distanse){
                distanse = horses.get(i).distance;
                winner = horses.get(i);
            }
        }

        return winner;
    }

    void printWinner(){
        System.out.println("Winner is "+getWinner().getName()+"!");
    }

}
