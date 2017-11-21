package com.norg.worldofwaste;

import com.norg.worldofwaste.gameobjects.Subject;
import com.norg.worldofwaste.gameobjects.Valuable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ObjectProcessor {
    public static Logger LOGGER = LoggerFactory.getLogger(ObjectProcessor.class);
    private List<Subject> subjects = new ArrayList<>();
    private List<Valuable> valuables = new ArrayList<>();

    public void add(Object object) {
        LOGGER.info("Add object {}", object);
        if (object instanceof Subject) {
            Subject subject = (Subject) object;
            subjects.add(subject);
            for (Subject earlier : subjects) {
                earlier.modify(Collections.singletonList(subject), false);
            }
            subject.modify(subjects, false);
            subject.change(valuables, true, false);
        }
        if (object instanceof Valuable) {
            valuables.add((Valuable) object);
        }
    }

    public void remove(Object object) {
        if (object instanceof Subject) {
            Subject subject = (Subject) object;
            subjects.remove(subject);
            subject.modify(subjects, true);
        }
    }

    public void turn() {
        LOGGER.trace("Turn");
        for (Subject subject : subjects) {
            subject.change(valuables, false, false);
        }
    }

    public StateReport getStateReport() {
        return getStateReport(0);
    }

    private StateReport getStateReport(int turns) {
        StateReport stateReport = new StateReport();
        for (Valuable valuable : valuables) {
            stateReport.with(valuable);
        }
        return stateReport;
    }
}