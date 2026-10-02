# Order Service (sample project)

A small, production-style backend skeleton: Spring Boot 3 / Java 17 REST API,
JPA with PostgreSQL, Docker, CI, a Terraform starter and architecture notes.

## Run locally
    mvn spring-boot:run                 # in-memory H2
    docker compose up --build           # app + PostgreSQL on :8080

## Try it
    curl -X POST localhost:8080/api/v1/orders \
      -H 'Content-Type: application/json' \
      -d '{"customerId":"c-1","amount":10.50}'
    curl localhost:8080/actuator/health

## Test
    mvn verify

## Docs
- docs/architecture.md - overview and quality attributes
- docs/adr/ - architecture decision records
