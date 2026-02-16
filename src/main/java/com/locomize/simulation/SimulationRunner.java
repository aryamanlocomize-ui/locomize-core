package com.locomize.simulation;

import java.util.List;
import java.util.UUID;

import com.locomize.kernel.Kernel;
import com.locomize.model.Pragati;
import com.locomize.model.PragatiState;
import com.locomize.model.TrackSection;
import com.locomize.scheduler.SimpleScheduler;

public class SimulationRunner {

    public static void run() {

        System.out.println("Trajectory engine initialized");
        System.out.println("Track registry loaded");
        System.out.println("Station registry loaded");

        // Create Pragatis
        Pragati p1 = new Pragati(UUID.randomUUID());
        p1.transitionTo(PragatiState.IDLE);

        Pragati p2 = new Pragati(UUID.randomUUID());
        p2.transitionTo(PragatiState.IDLE);

        List<Pragati> pragatis = List.of(p1, p2);

        // Create ONE TrackSection
        TrackSection s1 = new TrackSection(
                UUID.randomUUID(),
                1200,   // meters
                20,     // m/s
                30      // headway seconds
        );

        List<TrackSection> sections = List.of(s1);

        // Scheduler
        SimpleScheduler scheduler = new SimpleScheduler();

        // Kernel with sections
        Kernel kernel = new Kernel(scheduler, pragatis, sections);

        // First tick
        long intervalStart = 13 * 3600 + 59 * 60;
        kernel.runOneTick(intervalStart);
    }
}
