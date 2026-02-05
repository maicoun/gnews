# Architecture

## Overview
- **Style**: Layered Architecture (Spring MVC Standard).
- **Data Persistence**: **In-Memory** only. No external database connection for the main application.
- **Data Initialization**: Use `CommandLineRunner` (or a dedicated Initializer Bean) to populate the in-memory structures with specific fake datasets at startup.

## Constraints
- **External Calls**: STRICTLY FORBIDDEN. No HTTP calls to external APIs.
- **Nature**: This is a **Simulation/Mock** application.
  - NOT a crawler.
  - NOT an aggregator.
  - NOT a proxy.

## Architectural Decisions

### ADR-001: In-Memory Data Storage
**Context**: The application requires high performance and setup simplicity for mocking purposes.
**Decision**: Use `ConcurrentHashMap` or thread-safe collections within Repositories to store data.
**Consequence**: Data is volatile and lost on restart. No database schema management required.

### ADR-002: Simulation Mode
**Context**: We need to replicate GNews API behavior without relying on real news aggregators.
**Decision**: Pre-generate or synthetically generate news articles using internal logic and faker libraries.
**Consequence**: Content will be static or semi-random; true real-time news is out of scope.

### ADR-003: No External Network Logic
**Context**: To ensure stability and encapsulated sandbox behavior.
**Decision**: All "remote" resources (images, source URLs) must be defined as static strings or royalty-free placeholders.
**Consequence**: No network latency issues, predictable testing environment.
