package com.norg.worldofwaste;

import com.norg.worldofwaste.gameobjects.Valuable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StateReport {
    private List<Valuable> valuables = new ArrayList<>();

    public StateReport with(Valuable valuable) {
        valuables.add(valuable);
        return this;
    }

    public List<Valuable> getValuables() {
        return Collections.unmodifiableList(valuables);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Valuable valuable : valuables) {
            stringBuilder.append(valuable.getName());
            stringBuilder.append(": ");
            stringBuilder.append(valuable.getValue());
            stringBuilder.append("\n");
        }
        stringBuilder.append("============================\n");
        return stringBuilder.toString();
    }
}
