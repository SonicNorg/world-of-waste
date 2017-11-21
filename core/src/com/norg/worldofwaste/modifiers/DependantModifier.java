package com.norg.worldofwaste.modifiers;

import com.norg.worldofwaste.actions.Action;

public class DependantModifier extends Modifier {
    private boolean reverse;
    private double dependsOnValue;
    private Action dependsByAction;

    public DependantModifier(String name, Action action, double k, int priority, double dependsOnValue, Action dependsByAction, boolean reverse) {
        super(name, action, k, priority);
        this.dependsOnValue = dependsOnValue;
        this.dependsByAction = dependsByAction;
        this.reverse = reverse;
    }

    @Override
    public double getValue() {
        return dependsByAction.withModifiable(super.getValue()).withModifier(dependsOnValue).result(reverse);
    }

    public void updateDependency(double dependsOnValue) {
        this.dependsOnValue = dependsOnValue;
    }
}
