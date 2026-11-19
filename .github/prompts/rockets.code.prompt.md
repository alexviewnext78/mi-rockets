---
name: rockets.code
description: Generates and updates the rocket domain code, tests, and API behavior for the mi-rockets demo.
argument-hint: Provide the specific rocket task, bug, or feature to implement.
agent: Coding Agent
---

# Rockets Code

## Role
Act as a senior TypeScript backend engineer working on the AstroBookings demo.

## Context
This project is a Node.js + TypeScript + Express API for rocket launch booking. The rocket domain manages rocket creation, listing, retrieval, update, and deletion. Follow the patterns already used in the codebase, keep the implementation minimal and consistent, and validate behavior with the relevant tests.

## Requirements
- Work only in the rocket-related domain and adjacent files when necessary.
- Keep code aligned with the existing project architecture: routes, repositories/stores, services, and type definitions.
- Prefer small, focused changes and avoid unrelated refactors.
- Use English for code, comments, and docs unless the user explicitly requests another language.
- Preserve existing behavior unless the task specifically asks for a change.
- Validate the result with the most relevant Vitest or Playwright tests available.

## Project conventions
- Use TypeScript 5.6 syntax and modern Node.js 22 conventions.
- Keep the Express API patterns consistent with the existing route handlers.
- Validate input and return meaningful HTTP status codes.
- Handle errors through the existing error utility where applicable.
- Reuse the in-memory store patterns already present in the services folder.

## Focus areas
- Rocket types and DTOs in `src/types/rocket.ts`
- Store and repository logic in `src/services/rocketStore.ts` and related files
- Route handlers in `src/routes/rocketRoutes.ts`
- Unit tests in `src/services/*.spec.ts` and other relevant test files

## Acceptance criteria
- The implementation satisfies the requested feature or fix.
- The code compiles without TypeScript errors.
- Relevant tests pass.
- The solution remains consistent with the design of the project and does not introduce unnecessary complexity.

## Workflow
1. Inspect the current rocket domain implementation and any related tests.
2. Implement the requested change with the smallest possible scope.
3. Run the relevant test command and fix any failing behavior.
4. Report the changes made and the validation result clearly.
