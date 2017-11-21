package com.norg.worldofwaste.actions;

public interface Action {
    Action withModifiable(double modifiable);
    Action withModifier(double modifier);
    double result(boolean reverse);
}
