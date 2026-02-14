package com.locomize.simulation;

public class SimulationClock {

    private long currentTime;

    public SimulationClock(long startTime) {
        this.currentTime = startTime;
    }

    public void tick(long seconds) {
        currentTime += seconds;
    }

    public long now() {
        return currentTime;
    }
}
