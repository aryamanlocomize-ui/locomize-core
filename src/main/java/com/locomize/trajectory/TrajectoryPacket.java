package com.locomize.trajectory;

import com.locomize.model.PragatiState;
import java.util.List;
import java.util.UUID;

public class TrajectoryPacket {

    public UUID packetId;
    public UUID pragatiId;

    public long intervalStart;
    public long intervalEnd;
    public long expiryTime;

    public List<PragatiState> allowedStartStates;
    public PragatiState expectedEndState;

    public List<PlannedSection> plannedSections;

    public boolean isValidFor(PragatiState currentState, long now) {
        if (!allowedStartStates.contains(currentState)) return false;
        if (now > expiryTime) return false;
        return true;
    }
}
