package com.locomize.model;

import java.util.UUID;

public class TrackSection {

    private final UUID id;
    private final double lengthMeters;
    private final double maxSpeedMps;
    private final int headwaySeconds;

    private boolean occupied = false;
    private long occupiedUntil = 0;

    public TrackSection(UUID id,
                        double lengthMeters,
                        double maxSpeedMps,
                        int headwaySeconds) {
        this.id = id;
        this.lengthMeters = lengthMeters;
        this.maxSpeedMps = maxSpeedMps;
        this.headwaySeconds = headwaySeconds;
    }

    public UUID getId() {
        return id;
    }

    public double calculateTravelTimeSeconds() {
        return lengthMeters / maxSpeedMps;
    }

    public boolean isAvailable(long now) {
        return !occupied || now >= occupiedUntil;
    }

    public void occupyUntil(long releaseTime) {
        this.occupied = true;
        this.occupiedUntil = releaseTime;
    }

    public void update(long now) {
        if (occupied && now >= occupiedUntil) {
            occupied = false;
        }
    }
}
