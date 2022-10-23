package com.javarush.ua.marzhiievskyi.entity.organisms.actions;

import com.javarush.ua.marzhiievskyi.entity.field.Cell;

import java.io.IOException;

public interface Eatable {

    void eat(Cell cell) throws IOException;
}
