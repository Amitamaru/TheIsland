package com.javarush.marzhiievskyi.services;

import com.javarush.marzhiievskyi.entity.field.GameField;

public class IslandFactory {
    private final GameField gameField;

    public IslandFactory(int row, int columns) {
        gameField = GameField.getGameField(row, columns);
        gameField.initField();
    }

    public GameField getGameField() {
        return gameField;
    }
}
