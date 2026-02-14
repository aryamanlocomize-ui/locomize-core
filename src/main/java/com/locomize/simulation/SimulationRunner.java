package com.locomize.simulation;

import com.locomize.kernel.Kernel;
import com.locomize.model.Pragati;
import com.locomize.model.PragatiState;
import com.locomize.scheduler.SimpleScheduler;

import java.util.List;
import java.util.UUID;

public class SimulationRunner {

    public static void run() {

        // Create Pragatis
        Pragati p1 = new Pragati(UUID.randomUUID());
        p1.transitionTo(PragatiState.IDLE);

        Pragati p2 = new Pragati(UUID.randomUUID());
        p2.transitionTo(PragatiState.IDLE);

        List<Pragati> pragatis = List.of(p1, p2);

        // Scheduler
        SimpleScheduler scheduler = new SimpleScheduler();

        // Kernel
        Kernel kernel = new Kernel(scheduler, pragatis);

        // First scheduler tick
        long intervalStart = 13 * 3600 + 59 * 60; // 13:59:00
        kernel.runOneTick(intervalStart);
    }
}
