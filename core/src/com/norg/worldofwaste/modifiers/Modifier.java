package com.norg.worldofwaste.modifiers;

import com.norg.worldofwaste.Changeable;
import com.norg.worldofwaste.actions.Action;

public class Modifier implements Changeable {
    public static final String VALUE = "Value";
    private double k;
    private String name;
    private Action action;
    private int priority;

    public Modifier(String name, Action action, double k) {
        this(name, action, k, 1);
    }
    public Modifier(String name, Action action, double k, int priority) {
        this.name = name;
        this.action = action;
        this.k = k;
        this.priority = priority;
    }

    public void modify(Changeable changeable, boolean reverse) {
        changeable.setValue(action.withModifiable(changeable.getValue()).withModifier(getValue()).result(reverse));
    }

    @Override
    public double getValue() {
        return k;
    }

    @Override
    public void setValue(double value) {
        k = value;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }
}
