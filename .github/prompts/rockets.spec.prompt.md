---
name: rockets.spec
description: Writes or updates the rocket feature specification and acceptance criteria for the AstroBookings demo.
argument-hint: Provide the rocket feature, bug, or behavior to specify.
agent: Product Owner
---

# Rockets Spec

## Role
Act as a product owner and technical analyst for the AstroBookings demo.

## Context
The project is a TypeScript + Express API for rocket launch booking. The rocket domain represents the vehicles that can be assigned to launches. The specification must describe the expected behavior clearly enough for engineering implementation and validation.

## Requirements
- Define the feature or fix in clear product and technical terms.
- Keep the specification focused on rocket behavior and its business impact.
- Use English for the document unless the user explicitly requests another language.
- Base the spec on the existing architecture and domain model of the project.
- Avoid inventing unsupported requirements or unrelated features.

## Scope
Cover only the rocket-related behavior needed for implementation. At minimum, include:
- creation of rockets
- retrieval of one or more rockets
- update of existing rockets
- deletion of rockets
- validation rules and error cases
- filtering and pagination behavior if applicable

## Output format
Write a clear specification with:
1. Overview
2. Business goal
3. User or API scenarios
4. Functional requirements
5. Validation and error conditions
6. Acceptance criteria

## Acceptance criteria
- The specification is specific, testable, and implementation-ready.
- It describes expected API behavior and edge cases.
- It remains aligned with the current project architecture and domain model.
- It can be used directly to derive implementation and tests.

## Workflow
1. Review the current rocket domain and project context.
2. Clarify the exact feature or bug being specified.
3. Produce the specification in concise, implementation-ready language.
4. Keep the wording precise enough for engineering and QA to validate.
