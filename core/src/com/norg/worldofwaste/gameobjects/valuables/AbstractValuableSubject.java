package com.norg.worldofwaste.gameobjects.valuables;

import com.norg.worldofwaste.gameobjects.Subject;
import com.norg.worldofwaste.gameobjects.Valuable;

public class AbstractValuableSubject extends Subject implements Valuable {
    private double value;

    public AbstractValuableSubject(String name) {
        super(name);
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
