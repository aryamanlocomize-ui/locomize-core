package com.locomize.trajectory;

import java.util.UUID;

public class PlannedSection {

    public UUID sectionId;
    public long entryTime;
    public long exitTime;

    public PlannedSection(UUID sectionId, long entryTime, long exitTime) {
        this.sectionId = sectionId;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }
}
