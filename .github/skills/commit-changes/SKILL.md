---
name: commit-changes
description: >
  Commits pending changes.
  To be used when you have made changes to the code and want to commit them to the repository.
--

## Commiting changes Skill

When asked to commit changes, you should follow these steps:

1. **Check for uncommitted changes**: 
-Use `git status` to see if there are any changes that need to be committed.

2. **Group changes**: 
-If you have multiple changes, group them logically if possible. This will make it easier to understand the purpose of each commit.
-Decide on meaningful commit messages that clearly describe the changes made for each group of changes.

3. **Stage changes**:
-Stage the changes you want to commit using `git add <file>` for specific files or `git add .` to stage all changes in a group.

4. **Commit changes**:
-Commit the staged changes using [conventional commit messages](./conventional-commits.md) guidelines.