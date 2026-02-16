package com.locomize.scheduler;

import java.util.List;

import com.locomize.model.Pragati;
import com.locomize.model.TrackSection;
import com.locomize.trajectory.TrajectoryPacket;

public interface Scheduler {

    List<TrajectoryPacket> planNextInterval(
            long intervalStart,
            long intervalEnd,
            List<Pragati> pragatis,
            List<TrackSection> trackSections
    );
}
