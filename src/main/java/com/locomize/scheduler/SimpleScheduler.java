package com.locomize.scheduler;

import com.locomize.model.Pragati;
import com.locomize.model.PragatiState;
import com.locomize.model.TrackSection;
import com.locomize.trajectory.PlannedSection;
import com.locomize.trajectory.TrajectoryPacket;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SimpleScheduler implements Scheduler {

    @Override
    public List<TrajectoryPacket> planNextInterval(
            long intervalStart,
            long intervalEnd,
            List<Pragati> pragatis,
            List<TrackSection> trackSections
    ) {

        List<TrajectoryPacket> packets = new ArrayList<>();

        if (trackSections.isEmpty()) return packets;

        TrackSection section = trackSections.get(0);

        for (Pragati p : pragatis) {

            // Only move first eligible Pragati
            if (p.getState() == PragatiState.IDLE && !section.isOccupied()) {

                double travelTime = section.calculateTravelTimeSeconds();

                long entryTime = intervalStart;
                long exitTime = intervalStart + (long) travelTime;

                if (exitTime > intervalEnd) {
                    exitTime = intervalEnd;
                }

                PlannedSection plannedSection =
                        new PlannedSection(
                                section.getId(),
                                entryTime,
                                exitTime
                        );

                TrajectoryPacket packet = new TrajectoryPacket();
                packet.packetId = UUID.randomUUID();
                packet.pragatiId = p.getId();
                packet.intervalStart = intervalStart;
                packet.intervalEnd = intervalEnd;
                packet.expiryTime = intervalEnd + 60;

                packet.allowedStartStates = List.of(PragatiState.IDLE);
                packet.expectedEndState = PragatiState.MOVING;
                packet.plannedSections = List.of(plannedSection);

                section.occupy(); // reserve section

                packets.add(packet);
                break; // move only ONE Pragati
            }
        }

        return packets;
    }
}
