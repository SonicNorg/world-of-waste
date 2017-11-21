package com.norg.worldofwaste.gameobjects.valuables;

import com.norg.worldofwaste.actions.AddAction;
import com.norg.worldofwaste.actions.MultiplyAction;
import com.norg.worldofwaste.actions.SetAction;
import com.norg.worldofwaste.gameobjects.Subject;
import com.norg.worldofwaste.gameobjects.Valuable;
import com.norg.worldofwaste.modifiers.DependantModifier;
import com.norg.worldofwaste.modifiers.Modifier;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class TotalPopulation extends Subject implements Valuable {
    private double value;
    private List<DependantModifier> valueDependantModifiers;

    public TotalPopulation() {
        super("TotalPopulation");
        valueDependantModifiers = new ArrayList<>();

        value = 10_000;

        List<Pair<Boolean, Modifier>> self = new ArrayList<>();
        self.add(Pair.of(
                false, new Modifier(Modifier.VALUE, new MultiplyAction(), 1.5, -1)
        ));
        modifiers.put(name, self);

        List<Pair<Boolean, Modifier>> availablePopulation = new ArrayList<>();
        DependantModifier availPopMod = new DependantModifier(Modifier.VALUE, new SetAction(), 1, 0, value, new MultiplyAction(), false);
        availablePopulation.add(Pair.of(false, availPopMod));
        availablePopulation.add(Pair.of(true, availPopMod));
        valueDependantModifiers.add(availPopMod);
        modifiers.put("AvailablePopulation", availablePopulation);

        List<Pair<Boolean, Modifier>> waste = new ArrayList<>();
        DependantModifier wasteMod = new DependantModifier(Modifier.VALUE, new AddAction(), 0.5, 1, value, new MultiplyAction(), false);
        waste.add(Pair.of(false, wasteMod));
        valueDependantModifiers.add(wasteMod);
        modifiers.put("Waste", waste);
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public void setValue(double value) {
        this.value = value;
        updateDependantModifiers();
    }

    private void updateDependantModifiers() {
        for (DependantModifier valueDependantModifier : valueDependantModifiers) {
            valueDependantModifier.updateDependency(value);
        }
    }
}
