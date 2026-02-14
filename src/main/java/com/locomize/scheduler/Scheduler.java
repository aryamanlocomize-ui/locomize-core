package com.locomize.scheduler;

import com.locomize.model.Pragati;
import com.locomize.trajectory.TrajectoryPacket;

import java.util.List;

public interface Scheduler {

    List<TrajectoryPacket> planNextInterval(
            long intervalStart,
            long intervalEnd,
            List<Pragati> pragatis
    );
}
