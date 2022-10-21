package com.javarush.marzhiievskyi.services.factories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.javarush.marzhiievskyi.entity.field.GameField;
import com.javarush.marzhiievskyi.utils.Constants;
import com.javarush.marzhiievskyi.utils.gettingParameters.ParametersOfIsland;

import java.io.File;
import java.io.IOException;

public class IslandFactory {
    private final GameField gameField;
    private final ParametersOfIsland parametersOfIsland;

    public IslandFactory() {
        ObjectMapper mapper = new YAMLMapper();
        try {
            parametersOfIsland = mapper.readValue(new File(Constants.GAME_ISLAND_PARAMETERS_FILE_PATH), ParametersOfIsland.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        gameField = GameField.getGameField(parametersOfIsland.getRows(), parametersOfIsland.getColumns());
        gameField.initField();
    }

    public GameField getGameField() {
        return gameField;
    }

    public ParametersOfIsland getParametersOfIsland() {
        return parametersOfIsland;
    }
}
