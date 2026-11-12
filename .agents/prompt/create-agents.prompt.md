---
name: create-agents
description: Generates AGENTS.md by filling a repository-specific agent-instructions template.
argument-hint: Provide any extra guidance or scope to include in AGENTS.md.
agent: Coding Agent
---

# AGENTS.md Template

Create or update the root `AGENTS.md` using the template below.

Before writing, inspect the repository's build files, source tree, documentation, tests, and existing agent prompts. Replace every bracketed placeholder with verified project information. Omit optional sections that do not apply. Do not invent tools, frameworks, features, commands, or tests. Preserve accurate existing instructions and any additional user-provided requirements.

Only modify the root `AGENTS.md`. Write it in English unless the user requests another language. Keep it concise, actionable, and specific to the current repository.

## Template

````markdown
# Agent Instructions for [PROJECT_NAME]

## Project Overview
[Describe the project's purpose and the functionality currently implemented. Distinguish current behavior from planned work.]

## Technology
- **Language/runtime:** [Verified language and runtime versions]
- **Build:** [Build tool and relevant project coordinates or configuration]
- **Frameworks/dependencies:** [Only major dependencies confirmed in manifests]
- **Data/storage:** [Current persistence or storage approach, if applicable]

## Repository Structure
```text
[Show only important existing directories and files, with short descriptions.]
```

## Implementation Guidance
- [Architecture and code conventions evidenced by the repository]
- [Validation, error handling, and data integrity expectations]
- [Scope boundaries and behavior that must not be assumed]
- [Documentation, naming, and language conventions]

## Build and Validation
```sh
[List exact, verified commands for build, tests, lint, or other relevant checks.]
```
- [Clarify which checks exist and how to report skipped or unavailable checks.]

## Workflow
1. Inspect [relevant source, specifications, and tests].
2. Make the smallest change that satisfies the request and preserve unrelated work.
3. Run [appropriate validation commands].
4. Report changes, validation results, and remaining limitations.

## Agent Resources
- [List relevant existing instruction, prompt, or skill files; omit if none exist.]
````

After filling the template, verify that no bracketed placeholders remain, all paths and commands exist, and every statement matches repository evidence. Do not run builds solely to validate this documentation-only change. Summarize the updated file and note that no code validation was needed.