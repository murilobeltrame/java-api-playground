# Spring API playground

This repo shows of how to create super simple JAVA API using Spring Boot (Company API) or Jersey (Vehicle API).<br />
It also explore how to do it by older version of JAVA (1.8, sorry =P).<br />
Main objective is generate Open API style documentation for both APIs and them merge it in one single file.<br />
To do so:

- Get _Open Api_ specification from `company-api`:
  - Navigate to `src/company-api`
  - Run `./mvnw spring-boot:run -Dmaven.test.skip=true`
  - Grab the spec from `http://localhost:9998/api-docs` and save it
- Get _Open Api_ specification from `vehicle-api`:
  - Navigate to `src/vehicle-api`
  - Run `./mvnw spring-boot:run -Dmaven.test.skip=true`
  - Grab the spec from `http://localhost:9999/api-docs` and save it
- Run merger
  - Update `src/index.json` to fix file paths.
  - Run `npx swagger-merger --input index.json`

## Dependencies

- [Java 8](https://docs.aws.amazon.com/corretto/latest/corretto-8-ug/downloads-list.html)
- [Node JS](https://nodejs.org/it)

## Refs

- https://holon-platform.com/blog/spring-boot-jersey-and-swagger-always-happy-together/
- https://ruuben.medium.com/documenting-spring-boot-2-5-x-apis-using-openapi-3-0-6334984c6744
- https://github.com/WindomZ/swagger-merger
