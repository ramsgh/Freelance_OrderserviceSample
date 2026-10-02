# Architecture overview

    Client --> API (Spring Boot, REST /api/v1) --> PostgreSQL
                      |
                 Actuator (/actuator/health) --> load balancer / k8s probes

## Key decisions
- REST + RFC 7807 problem responses; DTO records separate from entities.
- Timestamps stored in UTC (`Instant`); conversion only at the edge.
- Config via environment variables (12-factor); H2 default for local/tests.
- Containerised (multi-stage, non-root); CI builds and tests on every PR.
- Infrastructure as code with Terraform (starter in /terraform).

## Quality attributes and next steps
| Concern | Now | Next |
|---|---|---|
| Scalability | Stateless app, horizontal scaling | Read replicas, caching |
| Reliability | Health checks, validation | Retries/idempotency keys, DR plan |
| Security | Non-root container, validation | AuthN/Z (OAuth2/JWT), secrets manager |
| Observability | Actuator health | Metrics (Prometheus), tracing, log aggregation |
| Data | JPA auto-DDL (demo) | Flyway migrations |
