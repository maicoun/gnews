# Technology Stack

## Core
- **Language**: Java 25
- **Framework**: Spring Boot (Latest compatible with Java 25)
- **Build Tool**: Maven

## Approved Dependencies
The following dependencies are **MANDATORY**:
- `spring-boot-starter-web`
- `spring-boot-starter-validation`
- `springdoc-openapi` (or `springdoc-openapi-starter-webmvc-ui` for Swagger UI)
- `jackson-databind`

## Optional Dependencies
- `com.h2database:h2` (Scope: TEST Only)

## Forbidden Dependencies
Usage of the following is **STRICTLY PROHIBITED**:
- `org.springframework.boot:spring-boot-starter-webflux` (WebClient)
- `org.springframework.web.client.RestTemplate`
- `org.jsoup:jsoup`
- `org.seleniumhq.selenium`
- `org.springframework.cloud:spring-cloud-starter-openfeign`

## Configuration
- All configuration must happen via `application.yml`. No `application.properties`.
> ANY dependency outside this list MUST NOT be used.
