# Agent instructions

## Project overview

This repository is a small Java demo for the AstroBookings rocket domain. It currently implements rocket data and lifecycle operations through domain, service, and repository classes. Do not assume the wider booking API, launch management, customers, or payment flows are implemented.

## Technology

- Java 17.
- Maven; coordinates are `com.example:mi-rockets:1.0-SNAPSHOT`.
- Plain Java with an in-memory rocket repository. There is no Spring Boot, Express, Node.js, database, or external runtime framework configured.
- The current `pom.xml` does not declare test libraries or test plugins. Check the repository before assuming a test suite exists.

## Repository structure

```text
.
├── .agents/
│   └── prompt/                 # Rocket code, spec, release, and agent-authoring prompts
├── src/main/java/
│   ├── com/astrobookings/rockets/
│   │   ├── domain/             # Rocket model, status, and validation exception
│   │   ├── repositories/       # Repository contract and in-memory implementation
│   │   └── services/           # Rocket operations and business rules
│   └── com/example/            # Minimal example entry point
├── ROCKETS_SPEC.md             # Intended rocket feature behavior
└── pom.xml
```

## Implementation guidance

- Keep changes focused on the request and follow the existing `domain`, `repositories`, and `services` separation.
- Use Java 17 and existing Maven configuration. Do not add frameworks, dependencies, API layers, or unrelated features without a clear requirement.
- Treat `ROCKETS_SPEC.md` as the intended behavior, but verify the current implementation before claiming a requirement is already supported. If the spec and code differ, implement only what the task asks for and report relevant gaps.
- Preserve existing behavior unless a change is explicitly requested.
- Keep validation and business rules consistent with `RocketValidationException` and the existing service patterns. Validate before persisting changes.
- Write code, identifiers, comments, and project documentation in English unless the user asks otherwise. Reply in the user's language and be concise.
- Do not invent requirements or silently change unrelated user edits. Ask one focused question if a decision blocks implementation.

## Build and validation

Run Maven from the repository root:

```bash
mvn test
```

If there are no tests or `mvn test` does not exercise a relevant check, run:

```bash
mvn package
```

Run the narrowest relevant validation after changes. Report the exact command and outcome; distinguish a successful build from tests actually being present and executed.

## Workflow

1. Read the relevant source files and `ROCKETS_SPEC.md` before editing.
2. Make the smallest change that fully addresses the request; update directly related documentation when behavior changes.
3. Validate with the appropriate Maven command.
4. Summarize the changes, validation results, and any remaining risks or limitations.

## Existing prompts

- `.agents/prompt/rockets.code.prompt.md`: implementation tasks.
- `.agents/prompt/rockets.spec.prompt.md`: rocket specification tasks.
- `.agents/prompt/rockets.release.prompt.md`: release validation.
- `.agents/prompt/create-agents.prompt.md`: agent-instruction authoring.
