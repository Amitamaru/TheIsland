package com.javarush.ua.marzhiievskyi.entity.field;

import com.javarush.ua.marzhiievskyi.entity.organisms.Organism;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cell {
    private final Lock lock = new ReentrantLock(true);

    private final int i;
    private final int j;

    public Lock getLock() {
        return lock;
    }


    private Map<Organism, Set<Organism>> mapOfAnimalsOPnCell;

    public Cell(int i, int j, Map<Organism, Set<Organism>> mapOfAnimalsOPnCell) {
        this.i = i;
        this.j = j;
        this.mapOfAnimalsOPnCell = mapOfAnimalsOPnCell;

    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public Map<Organism, Set<Organism>> getMapOfAnimalsOnCell() {
        return mapOfAnimalsOPnCell;
    }

    public void setMapOfAnimalsOPnCell(Map<Organism, Set<Organism>> mapOfAnimalsOPnCell) {
        this.mapOfAnimalsOPnCell = mapOfAnimalsOPnCell;
    }



    public List<Cell> generateMoveList(Cell cell) {
        Cell[][] cells = GameField.getGameField().getFieldIsland();
        List<Cell> movementCells = new ArrayList<>();


        int i = cell.getI();
        int j = cell.getJ();

        if (i == 0 && j == 0) {
            movementCells.add(cells[i + 1][j]);
            movementCells.add(cells[i][j + 1]);
        } else if (i == (cells.length - 1) && j == 0) {
            movementCells.add(cells[i - 1][j]);
            movementCells.add(cells[i][j + 1]);
        } else if (i == (cells.length - 1) && j == (cells[i].length - 1)) {
            movementCells.add(cells[i - 1][j]);
            movementCells.add(cells[i][j - 1]);
        } else if (i == 0 && j == (cells[i].length - 1)) {
            movementCells.add(cells[i][j - 1]);
            movementCells.add(cells[i + 1][j]);
        } else if (i == 0 && j < (cells[i].length - 1)) {
            movementCells.add(cells[i][j - 1]);
            movementCells.add(cells[i][j + 1]);
            movementCells.add(cells[i + 1][j]);
        } else if (i < cells.length - 1 && j == 0) {
            movementCells.add(cells[i - 1][j]);
            movementCells.add(cells[i + 1][j]);
            movementCells.add(cells[i][j + 1]);
        } else if (i == (cells.length - 1) && j < (cells[i].length - 1)) {
            movementCells.add(cells[i][j - 1]);
            movementCells.add(cells[i][j + 1]);
            movementCells.add(cells[i - 1][j]);
        } else if (i < (cells.length - 1) && j == (cells[i].length - 1)) {
            movementCells.add(cells[i + 1][j]);
            movementCells.add(cells[i - 1][j]);
            movementCells.add(cells[i][j - 1]);
        } else {
            movementCells.add(cells[i][j - 1]);
            movementCells.add(cells[i][j + 1]);
            movementCells.add(cells[i - 1][j]);
            movementCells.add(cells[i + 1][j]);
        }

        return movementCells;
    }

    @Override
    public String toString() {
        return "Cell {" +
                "i=" + i +
                ", j=" + j +
                '}';
    }
}
