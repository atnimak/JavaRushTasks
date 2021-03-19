package com.javarush.task.task35.task3513;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    public Model(){
        for(int i = 0;i<FIELD_WIDTH;i++){
            for(int k = 0;k<FIELD_WIDTH;k++){
                gameTiles[i][k] = new Tile();
            }
        }

    }
}
