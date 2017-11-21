package com.norg.worldofwaste;

import com.norg.worldofwaste.gameobjects.valuables.AvailablePopulation;
import com.norg.worldofwaste.gameobjects.valuables.TotalPopulation;

import java.io.IOException;

public class Game {
    ObjectProcessor processor = new ObjectProcessor();

    public Game() throws InterruptedException, IOException {
        initGameObjects();
    }

    private void initGameObjects() {
        processor.add(new AvailablePopulation());
        processor.add(new TotalPopulation());
    }
    
    public void turn() {
        processor.turn();
    }

    public StateReport getStateReport() {
        return processor.getStateReport();
    }
}
