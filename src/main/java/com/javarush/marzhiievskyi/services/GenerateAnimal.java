package com.javarush.marzhiievskyi.services;


import com.javarush.marzhiievskyi.entity.AnimalNames;
import com.javarush.marzhiievskyi.entity.Parameters;
import com.javarush.marzhiievskyi.entity.animals.Animal;


import java.util.List;
import java.util.Map;

public class GenerateAnimal {

    public void initializationAnimals() {
        Parameters parameters = new Parameters();
        parameters.initAnimalParam();

        Map<AnimalNames, List<String>> animalsParameters = parameters.getMapOfAnimalsParameters();

        for (var animalParams: animalsParameters.entrySet()) {

            String type = animalParams.getValue().get(0);
            double animalWeight = Double.parseDouble(animalParams.getValue().get(1));
            int maxCountAnimalsOnCell = Integer.parseInt(animalParams.getValue().get(2));
            int maxMoveSpeed = Integer.parseInt(animalParams.getValue().get(3));
            double foodsNeeded = Double.parseDouble(animalParams.getValue().get(4));
        }
    }


}

