package com.norg.worldofwaste.actions;


public abstract class AbstractAction implements Action {
    protected double modifier;
    protected double modifiable;

    @Override
    public abstract double result(boolean reverse);

    @Override
    public Action withModifiable(double modifiable) {
        this.modifiable = modifiable;
        return this;
    }

    @Override
    public Action withModifier(double modifier) {
        this.modifier = modifier;
        return this;
    }
}
