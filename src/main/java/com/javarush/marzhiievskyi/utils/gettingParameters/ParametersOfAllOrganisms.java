package com.javarush.marzhiievskyi.utils.gettingParameters;

import java.util.List;

public class ParametersOfAllOrganisms {
    private List<OrganismParameters> organismParametersList;

    public List<OrganismParameters> getOrganismParametersList() {
        return organismParametersList;
    }

    public void setOrganismParametersList(List<OrganismParameters> organismParametersList) {
        this.organismParametersList = organismParametersList;
    }

    @Override
    public String toString() {
        return "All organism params: " + organismParametersList;
    }
}
