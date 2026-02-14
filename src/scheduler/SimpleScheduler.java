package com.locomize.scheduler;

import com.locomize.model.Pragati;
import com.locomize.model.PragatiState;
import com.locomize.trajectory.TrajectoryPacket;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SimpleScheduler implements Scheduler {

    @Override
    public List<TrajectoryPacket> planNextInterval(
            long intervalStart,
            long intervalEnd,
            List<Pragati> pragatis
    ) {

        List<TrajectoryPacket> packets = new ArrayList<>();

        for (Pragati p : pragatis) {
            if (p.getState() == PragatiState.IDLE) {

                TrajectoryPacket packet = new TrajectoryPacket();
                packet.packetId = UUID.randomUUID();
                packet.pragatiId = p.getId();

                packet.intervalStart = intervalStart;
                packet.intervalEnd = intervalEnd;
                packet.expiryTime = intervalEnd + 60; // buffer

                packet.allowedStartStates = List.of(PragatiState.IDLE);
                packet.expectedEndState = PragatiState.HOLDING;
                packet.plannedSections = List.of(); // no movement yet

                packets.add(packet);
            }
        }

        return packets;
    }
}
