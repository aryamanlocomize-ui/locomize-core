package com.locomize.model;

import java.util.UUID;

public class Dock {

    private final UUID dockId;
    private boolean occupied;

    public Dock(UUID dockId) {
        this.dockId = dockId;
        this.occupied = false;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void occupy() {
        this.occupied = true;
    }

    public void release() {
        this.occupied = false;
    }
}
