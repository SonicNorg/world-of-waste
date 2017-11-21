package com.norg.worldofwaste.gameobjects;

import com.norg.worldofwaste.modifiers.Modifier;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.norg.worldofwaste.modifiers.Modifier.VALUE;

public class Subject {
    protected String name;
    protected Map<String, List<Pair<Boolean, Modifier>>> modifiers;

    public Subject(String name) {
        this.name = name;
        modifiers = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void modify(List<Subject> subjects, boolean reverse) {
        for (Subject subject : subjects) {
            for (Pair<Boolean, Modifier> modifier : getModifiersByWho(subject.getName())) {
                for (Pair<Boolean, Modifier> modifiableModifier : subject.getModifiersByWho(modifier.getRight().getName())) {
                    modifier.getRight().modify(modifiableModifier.getRight(), reverse);
                }
            }
        }
    }

    public void change(List<Valuable> valuables, boolean instantly, boolean reverse) {
        class Holder {
            Valuable valuable;
            Boolean instantly;
            Modifier modifier;

            public Holder(Valuable valuable, Boolean instantly, Modifier modifier) {
                this.valuable = valuable;
                this.instantly = instantly;
                this.modifier = modifier;
            }
        }
        valuables.stream()
                .flatMap(valuable -> getModifiersByWho(valuable.getName()).stream()
                        .map(booleanModifierPair -> new Holder(valuable, booleanModifierPair.getLeft(), booleanModifierPair.getRight())))
                .filter(holder -> holder.instantly == instantly)
                .filter(holder -> holder.modifier.getName().equals(VALUE))
                .sorted((holder1, holder2) -> holder1.modifier.getPriority() < holder2.modifier.getPriority()
                        ? -1 : holder1.modifier.getPriority() == holder2.modifier.getPriority()
                        ? 0 : 1)
                .forEach(holder -> holder.modifier.modify(holder.valuable, reverse));
    }

    public List<Pair<Boolean, Modifier>> getModifiersByWho(String who) {
        return modifiers.getOrDefault(who, Collections.emptyList());
    }
}
