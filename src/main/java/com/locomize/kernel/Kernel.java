package com.locomize.kernel;

import com.locomize.model.Pragati;
import com.locomize.model.PragatiState;
import com.locomize.scheduler.Scheduler;
import com.locomize.trajectory.TrajectoryPacket;

import java.util.List;

public class Kernel {

    private final Scheduler scheduler;
    private final List<Pragati> pragatis;

    private final long intervalSeconds = 60;

    public Kernel(Scheduler scheduler, List<Pragati> pragatis) {
        this.scheduler = scheduler;
        this.pragatis = pragatis;
    }

    public void runOneTick(long intervalStart) {

        long intervalEnd = intervalStart + intervalSeconds;

        System.out.println("---------------------------------");
        System.out.println("Kernel tick: " + intervalStart + " → " + intervalEnd);

        List<TrajectoryPacket> packets =
                scheduler.planNextInterval(intervalStart, intervalEnd, pragatis);

        applyPackets(packets, intervalStart);

        System.out.println("Tick complete");
    }

    private void applyPackets(List<TrajectoryPacket> packets, long now) {

        for (TrajectoryPacket packet : packets) {
            Pragati pragati = pragatis.stream()
                    .filter(p -> p.getId().equals(packet.pragatiId))
                    .findFirst()
                    .orElse(null);

            if (pragati == null) continue;

            if (packet.isValidFor(pragati.getState(), now)) {
                pragati.transitionTo(packet.expectedEndState);
                System.out.println(
                        "Pragati " + pragati.getId() +
                        " → " + packet.expectedEndState
                );
            } else {
                System.out.println(
                        "Packet rejected for Pragati " + pragati.getId()
                );
            }
        }
    }
}
