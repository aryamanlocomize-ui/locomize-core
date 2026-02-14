package com.locomize.model;

import java.util.List;
import java.util.UUID;

public class Station {

    private final UUID id;
    private final List<Dock> docks;

    public Station(UUID id, List<Dock> docks) {
        this.id = id;
        this.docks = docks;
    }

    public Dock getAvailableDock() {
        return docks.stream()
                .filter(d -> !d.isOccupied())
                .findFirst()
                .orElse(null);
    }
}
