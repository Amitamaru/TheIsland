package com.javarush.marzhiievskyi.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.javarush.marzhiievskyi.entity.organisms.Organism;
import com.javarush.marzhiievskyi.utils.gettingParameters.ParametersOfAllOrganisms;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class OrganismFactory {
    private final String PATH_OF_PROPERTIES_ORGANISMS = "src/main/resources/OrganismsParameters.yaml";

    private Set<?> prototype;

    {
        try {
            prototype = gettingSetOfOrganisms(PATH_OF_PROPERTIES_ORGANISMS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Set<?> getPrototype() {
        return prototype;
    }

    public Set<?> gettingSetOfOrganisms(String yamlParametersFilePath) throws IOException {
        Set<Organism> organismSet = new HashSet<>();
        ObjectMapper mapper = new YAMLMapper();
        ParametersOfAllOrganisms params = mapper.readValue(new File(yamlParametersFilePath), ParametersOfAllOrganisms.class);

        params.getOrganismParametersList().forEach(el -> {
            String name = el.getName();
            String icon = el.getIcon();
            int speed = el.getMaxSpeedCells();
            double weight = el.getWeight();
            double needFood = el.getNeedFood();
            organismSet.add(new Organism(icon, weight, speed, needFood));

        });
        return organismSet;
    }

}

