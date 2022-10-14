package com.javarush.marzhiievskyi.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.javarush.marzhiievskyi.entity.organisms.Organism;
import com.javarush.marzhiievskyi.entity.organisms.carnivorous.*;
import com.javarush.marzhiievskyi.entity.organisms.herbivorous.*;
import com.javarush.marzhiievskyi.entity.organisms.plants.Grass;
import com.javarush.marzhiievskyi.utils.EnumOrganisms;
import com.javarush.marzhiievskyi.utils.gettingParameters.OrganismParameters;
import com.javarush.marzhiievskyi.utils.gettingParameters.ParametersOfAllOrganisms;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.security.PublicKey;
import java.util.*;

public class OrganismFactory {


    private final String PATH_OF_PROPERTIES_ORGANISMS = "src/main/resources/OrganismsParameters.yaml";

    public List<Organism> gettingSetOfOrganisms() throws IOException {
        List<Organism> organismSet = new ArrayList<>();
        ObjectMapper mapper = new YAMLMapper();
        ParametersOfAllOrganisms paramOfAllOrg = mapper.readValue(new File("src/main/resources/OrganismsParameters.yaml"), ParametersOfAllOrganisms.class);
        List<OrganismParameters> organismParametersList = paramOfAllOrg.getOrganismParametersList();
        organismParametersList.forEach(organism -> {
            String name = organism.getName();
            String icon = organism.getIcon();
            double weight = organism.getWeight();
            int countOnCell = organism.getMaxCountOnCell();
            int maxSpeed = organism.getMaxSpeedCells();
            double foodNeed = organism.getNeedFood();
            Object[] params = new Object[]{name, icon, weight, countOnCell, maxSpeed, foodNeed};
            organismSet.add(createOrganism(EnumOrganisms.valueOf(name.toUpperCase()), params));
        });

        return organismSet;
    }

    private Organism createOrganism(EnumOrganisms typeOfOrganism, Object[] array) {
        Organism newOrganism = null;

        switch (typeOfOrganism) {
            case FOX ->
                    newOrganism = new Fox((String) array[0], (String) array[1], (Double) array[2], (Integer) array[3], (Integer) array[4], (Double) array[5]);
            case BEAR ->
                    newOrganism = new Bear((String) array[0], (String) array[1], (Double) array[2], (Integer) array[3], (Integer) array[4], (Double) array[5]);
            case BOAR ->
                    newOrganism = new Boar((String) array[0], (String) array[1], (Double) array[2], (Integer) array[3], (Integer) array[4], (Double) array[5]);
            case DEER ->
                    newOrganism = new Deer((String) array[0], (String) array[1], (Double) array[2], (Integer) array[3], (Integer) array[4], (Double) array[5]);
            case DUCK ->
                    newOrganism = new Duck((String) array[0], (String) array[1], (Double) array[2], (Integer) array[3], (Integer) array[4], (Double) array[5]);
            case GOAT ->
                    newOrganism = new Goat((String) array[0], (String) array[1], (Double) array[2], (Integer) array[3], (Integer) array[4], (Double) array[5]);
            case EAGLE ->
                    newOrganism = new Eagle((String) array[0], (String) array[1], (Double) array[2], (Integer) array[3], (Integer) array[4], (Double) array[5]);
            case HORSE ->
                    newOrganism = new Horse((String) array[0], (String) array[1], (Double) array[2], (Integer) array[3], (Integer) array[4], (Double) array[5]);
            case MOUSE ->
                    newOrganism = new Mouse((String) array[0], (String) array[1], (Double) array[2], (Integer) array[3], (Integer) array[4], (Double) array[5]);
            case SHEEP ->
                    newOrganism = new Sheep((String) array[0], (String) array[1], (Double) array[2], (Integer) array[3], (Integer) array[4], (Double) array[5]);
            case SNAKE ->
                    newOrganism = new Snake((String) array[0], (String) array[1], (Double) array[2], (Integer) array[3], (Integer) array[4], (Double) array[5]);
            case WOOLF ->
                    newOrganism = new Woolf((String) array[0], (String) array[1], (Double) array[2], (Integer) array[3], (Integer) array[4], (Double) array[5]);
            case RABBIT ->
                    newOrganism = new Rabbit((String) array[0], (String) array[1], (Double) array[2], (Integer) array[3], (Integer) array[4], (Double) array[5]);
            case BUFFALO ->
                    newOrganism = new Buffalo((String) array[0], (String) array[1], (Double) array[2], (Integer) array[3], (Integer) array[4], (Double) array[5]);
            case CATERPILLAR ->
                    newOrganism = new Caterpillar((String) array[0], (String) array[1], (Double) array[2], (Integer) array[3], (Integer) array[4], (Double) array[5]);
            case GRASS ->
                    newOrganism = new Grass((String) array[0], (String) array[1], (Double) array[2], (Integer) array[3]);
        }
        return newOrganism;
    }


}

