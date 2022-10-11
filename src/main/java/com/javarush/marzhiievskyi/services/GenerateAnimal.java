package com.javarush.marzhiievskyi.services;


import com.javarush.marzhiievskyi.entity.AnimalNames;
import com.javarush.marzhiievskyi.entity.Parameters;


import java.util.List;
import java.util.Map;

public class GenerateAnimal {

    public void initializationAnimals() {
        Parameters parameters = new Parameters();
        parameters.addAnimalParam();

        Map<AnimalNames, List<String>> carnivorousAnimalsParameters = parameters.getCarnivorousAnimalsParameters();

        for (var animalParams: carnivorousAnimalsParameters.entrySet()) {

            String type = animalParams.getValue().get(0);
            double animalWeight = Double.parseDouble(animalParams.getValue().get(1));
            int maxCountAnimalsOnCell = Integer.parseInt(animalParams.getValue().get(2));
            int maxMoveSpeed = Integer.parseInt(animalParams.getValue().get(3));
            double foodsNeeded = Double.parseDouble(animalParams.getValue().get(4));


        }
    }


}

