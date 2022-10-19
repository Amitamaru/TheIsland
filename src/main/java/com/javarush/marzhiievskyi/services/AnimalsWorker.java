package com.javarush.marzhiievskyi.services;

import com.javarush.marzhiievskyi.entity.field.GameField;

import java.lang.reflect.Field;

public class AnimalsWorker implements Runnable {

    private GameField gameField = GameField.getGameField();


    @Override
    public void run() {
        //TODO across all cells and sets of organisms and do eat, move, multiply
    }
}
