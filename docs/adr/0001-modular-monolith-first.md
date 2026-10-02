# ADR 0001: Start as a modular monolith, extract services later

- Status: Accepted
- Context: A small team needs to ship an order capability quickly, but the
  system is expected to grow (payments, fulfilment, notifications).
- Options considered:
  1. Microservices from day one - independent scaling, but high operational
     cost and distributed-data complexity for a small team.
  2. Modular monolith - one deployable, clear package boundaries, simple
     transactions, cheap to run.
- Decision: Option 2. Keep domain boundaries explicit (package per domain,
  no cross-package repository access) so modules can be extracted later.
- Consequences: Faster delivery and simpler operations now. Revisit when a
  module needs independent scaling or release cadence; introduce events
  (e.g. Kafka) at that boundary rather than before.
