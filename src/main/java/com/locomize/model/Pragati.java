package com.locomize.model;

import java.util.UUID;

public class Pragati {

    private final UUID id;
    private PragatiState state;

    public Pragati(UUID id) {
        this.id = id;
        this.state = PragatiState.IDLE;
    }

    public UUID getId() {
        return id;
    }

    public PragatiState getState() {
        return state;
    }

    public void transitionTo(PragatiState newState) {
        this.state = newState;
    }
}
