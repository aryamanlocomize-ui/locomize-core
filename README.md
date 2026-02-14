# Locomize Core

**Locomize** is a railway‑grade simulation kernel designed to model track systems, stations, train movement, and scheduling logic in a modular, extensible architecture.

This repository contains the **core engine (v0.1.0)** — the foundation for building a full railway simulation and optimization platform.

---

# 🚆 Vision

Locomize aims to become a **next‑generation railway intelligence and simulation platform** capable of:

* Real‑time train movement simulation
* Track and station topology modeling
* Scheduling and dispatch optimization
* Future AI‑assisted railway planning

The long‑term goal is to evolve Locomize from a **simulation kernel** into a **complete railway operating intelligence system**.

---

# 🧠 Core Architecture

The Locomize kernel is structured around clean domain separation:

* **Track Registry** → Manages track sections and connectivity
* **Station Registry** → Stores station metadata and relationships
* **Trajectory Engine** → Computes movement across track graph
* **Simulation Scheduler** → Drives time progression and events
* **Kernel Runtime** → Boots and coordinates all subsystems

This modular design allows:

* Independent subsystem evolution
* Scalable simulation complexity
* Future plug‑in AI and optimization layers

---

# ⚙️ Current Version

**Version:** `v0.1.0`

Includes:

* Base simulation kernel startup
* Track registry initialization
* Station registry initialization
* Trajectory engine bootstrap
* First scheduler tick execution

This marks the **first runnable Locomize core build**.

---

# 🛠️ Tech Stack

* **Language:** Java
* **Build Tool:** Maven
* **Architecture Style:** Modular domain‑driven simulation kernel
* **Execution Mode:** Local JVM runtime

Future planned additions:

* REST simulation control API
* Visualization dashboard
* AI scheduling optimization

---

# ▶️ Running Locomize Locally

### 1. Clone repository

```bash
git clone https://github.com/aryamanlocomize-ui/locomize-core.git
cd locomize-core
```

### 2. Build with Maven

```bash
mvn clean package
```

### 3. Run the kernel

```bash
java -jar target/locomize-core-0.1.0.jar
```

Expected console output:

```
Locomize Core v0.1.0
Simulation kernel starting...
Trajectory engine initialized
Track registry loaded
Station registry loaded
Locomize kernel running
```

---

# 🗺️ Roadmap

## v0.2

* Train entity model
* Movement state updates per tick
* Basic scheduling loop

## v0.3

* Conflict detection on shared tracks
* Multi‑train simulation
* Event logging system

## v0.5

* REST control API
* Scenario configuration files
* Deterministic simulation replay

## v1.0

* AI‑assisted scheduling engine
* Visualization dashboard
* Performance optimization
* Public simulation SDK

---

# 🤝 Contributing

Locomize is currently in **early core development**.

Future contributions may include:

* Simulation algorithms
* Graph optimization
* Railway data modeling
* Visualization tools

Contribution guidelines will be added in upcoming releases.

---

# 📜 License

License will be defined before **v1.0 public release**.

---

# 👤 Author

**Aryaman Chaudhary**

Founder of the Locomize initiative — building intelligent railway simulation and optimization technology from first principles.

---

# 🌍 Project Status

**Active early‑stage engineering**
First public kernel successfully released on GitHub.

The journey to a full railway intelligence platform has begun.
