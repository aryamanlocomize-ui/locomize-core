package com.locomize.model;

import java.util.UUID;

public class TrackSection {

    private final UUID id;
    private final double lengthMeters;
    private final double maxSpeedMps;
    private final int headwaySeconds;

    public TrackSection(UUID id, double lengthMeters, double maxSpeedMps, int headwaySeconds) {
        this.id = id;
        this.lengthMeters = lengthMeters;
        this.maxSpeedMps = maxSpeedMps;
        this.headwaySeconds = headwaySeconds;
    }

    public UUID getId() {
        return id;
    }

    public double travelTimeSeconds() {
        return lengthMeters / maxSpeedMps;
    }
}
