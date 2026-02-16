package com.locomize;

import com.locomize.simulation.SimulationRunner;

public class LocomizeApplication {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(" Locomize Core v0.1.0 ");
        System.out.println(" Simulation kernel starting...");
        System.out.println("=================================");

        SimulationRunner.run();

        System.out.println("Locomize kernel running");
    }
}
