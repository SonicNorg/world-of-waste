package com.norg.worldofwaste.gameobjects.valuables;

import com.norg.worldofwaste.gameobjects.Valuable;

public class AvailablePopulation implements Valuable {
    private final String name;
    private double value;

    public AvailablePopulation() {
        this.name = "AvailablePopulation";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public void setValue(double value) {
        this.value = value;
    }
}
