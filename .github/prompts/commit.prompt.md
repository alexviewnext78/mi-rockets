---
name: commit
description: >
  Commits pending changes.
  To be used when you have made changes to the code and want to commit them to the repository.
  model: GPT-5 mini (copilot)
agent: agent
tools: [execute, read]
---

# Commit changes

## Role

Act as a senior software engineer with expertise in Git and version control systems.

## Task

Commit the pending changes in the repository following best practices for commit messages and version control.

## Context

Use the ´commit-changes´ skill to commit the changes made in the codebase. Ensure that the commit messages are clear, concise, and follow conventional commit guidelines.

## Output checklist

- [] there are no uncommitted changes left in the current branch.