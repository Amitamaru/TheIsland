package com.javarush.ua.marzhiievskyi.services.factories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.javarush.ua.marzhiievskyi.entity.field.GameField;
import com.javarush.ua.marzhiievskyi.utils.Constants;
import com.javarush.ua.marzhiievskyi.utils.gettingParameters.GettingParametersOfIsland;
import com.javarush.ua.marzhiievskyi.wiev.ConsoleGUI;

import java.io.File;
import java.io.IOException;

public class IslandFactory {
    private final GameField gameField;
    private final GettingParametersOfIsland gettingParametersOfIsland;

    public IslandFactory() {
        ObjectMapper mapper = new YAMLMapper();
        try {
            File gameIslandParameters = new File(Constants.GAME_ISLAND_PARAMETERS_FILE_PATH);
            gettingParametersOfIsland = mapper.readValue(gameIslandParameters, GettingParametersOfIsland.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        gameField = GameField.getGameField(gettingParametersOfIsland.getRows(), gettingParametersOfIsland.getColumns());
        gameField.initField();
        System.out.println(Constants.WELCOME_MSG);
        ConsoleGUI consoleGUI = new ConsoleGUI();
        consoleGUI.printField(getGameField());
        consoleGUI.printStatistic(getGameField());
        System.out.println(Constants.BETWEEN_INIT_AND_ALL_TICKS);
    }

    public GameField getGameField() {
        return gameField;
    }

    public GettingParametersOfIsland getParametersOfIsland() {
        return gettingParametersOfIsland;
    }
}
