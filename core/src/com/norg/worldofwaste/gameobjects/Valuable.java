package com.norg.worldofwaste.gameobjects;

import com.norg.worldofwaste.Changeable;

public interface Valuable extends Changeable {
    double getValue();
    void setValue(double value);
}
