---
name: rockets.code
description: Generates and updates the rocket domain code, tests, and API behavior for the AstroBookings demo.
argument-hint: Provide the specific rocket task, bug, or feature to implement.
agent: Coding Agent
---
The specification is already defined in the `ROCKETS_SPEC.md`. Use that specification to implement the requested feature, bug fix, or behavior in the codebase. Follow the project conventions and focus areas to ensure consistency and maintainability. Validate your changes with the relevant tests and report the results clearly. We are going to create the tests in the future.


# Rockets Code

## Role
Act as a senior Java backend engineer working on the AstroBookings demo.

## Context
This project is a java API for rocket launch booking. The rocket domain manages rocket creation, listing, retrieval, update, and deletion. Follow the patterns already used in the codebase, keep the implementation minimal and consistent.

## Requirements
- Work only in the rocket-related domain and adjacent files when necessary.
- Keep code aligned with the existing project architecture: routes, repositories/stores, services, and type definitions.
- Prefer small, focused changes and avoid unrelated refactors.
- Use English for code, comments, and docs unless the user explicitly requests another language.
- Preserve existing behavior unless the task specifically asks for a change.
- Dont create the tests yet, we will create them in the future.

## Project conventions
- Use Java 17 syntax and modern Spring Boot conventions.
- Keep the Spring API patterns consistent with the existing route handlers.
- Validate input and return meaningful HTTP status codes.
- Handle errors through the existing error utility where applicable.
- Reuse the in-memory store patterns already present in the services folder.

## Focus areas
- Rocket types and DTOs in `src/main/java/com/astrobookings/rockets/domain`
- Store and repository logic in `src/main/java/com/astrobookings/rockets/repositories` and related files
- Route handlers in `src/main/java/com/astrobookings/rockets/routes`
- Unit tests in `src/test/java/com/astrobookings/rockets/services` and other relevant test files

## Acceptance criteria
- The implementation satisfies the requested feature or fix.
- The code compiles without Java errors.
- The solution remains consistent with the design of the project and does not introduce unnecessary complexity.

## Workflow
1. Inspect the current rocket domain implementation and any related tests.
2. Implement the requested change with the smallest possible scope.
3. Report the changes made and the validation result clearly.
