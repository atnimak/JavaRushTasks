package com.javarush.task.task17.task1714;

/* 
Comparable
*/

import java.util.ArrayList;

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public  synchronized void setName(String name) {
        this.name = name;
    }

    public  synchronized float getDistance() {
        return distance;
    }

    public  synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized  int getQuality() {
        return quality;
    }

    public  synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public  static void main(String[] args) {
        ArrayList<Beach> beaches = new ArrayList<>();
        beaches.add(new Beach("beach1",135,5));
        beaches.add(new Beach("beach2",121,2));
        beaches.add(new Beach("beach3",143,4));
        beaches.add(new Beach("beach4",150,3));
        beaches.add(new Beach("beach5",34,5));
        beaches.add(new Beach("beach6",34,5));
        beaches.add(new Beach("beach7",34,6));
        beaches.add(new Beach("beach8",35,6));


        for (int i =0;i<beaches.size();i++) {
            for(int j = i+1;j<beaches.size()-1;j++){
                Beach b = beaches.get(i);
                Beach b2 = beaches.get(j);
                Beach temp;
                Beach temp1;
                int i1 = b.compareTo(b2);
                System.out.println(i1);
                System.out.println(b.getName()+" "+b.getDistance()+" "+b.getQuality() );
                System.out.println(b2.getName()+" "+b2.getDistance()+" "+b2.getQuality() );
            }
        }
    }

    @Override
    public  synchronized int compareTo(Beach o) {

        Beach entry = o;
        Integer quality1 = quality;
        Float distanse1 =  distance;
        int result;

        if(quality1>entry.quality){
            result = 1;
        }else if(quality1<entry.quality){
            result=-1;
        }else{
            result=0;
        }

        if(distanse1<entry.distance){
            result++;
        }else if(distanse1>entry.distance) {
            result--;
        }

        return result;
        /*
        int result = quality1.compareTo(entry.quality);
        if(result !=0){
            return result;
        }

        result = distanse1.compareTo(entry.distance);
        if(result !=0){
            return result;
        }*/
    }
}
