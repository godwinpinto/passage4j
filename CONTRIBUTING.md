# Contributing Guidelines
Some basic conventions for contributing to this project.

## General

Please make sure that there aren't existing pull requests attempting to address the issue mentioned. Likewise, please check for issues related to update, as someone else may be working on the issue in a branch or fork.

- Please open a discussion in a new issue / existing issue to talk about the changes you'd like to bring
- Take a fork for development if you are going to work on development 
- Once your development is completed submit a pull request describing your changes 

### Issues open to contribution

Want to contribute but don't know where to start? Have a look at the issues labeled with the `good first issue` label

## Commit Message Format

Each commit message should include a **type**, a **scope** and a **subject**:

```
 <type>(<scope>): <subject>
```

Lines should not exceed 100 characters. This allows the message to be easier to read on GitHub as well as in various git tools and produces a nice, neat commit log ie:

```
 #271 feat(service): add exposed ports in the containers view
 #270 fix(controller): fix a display issue in the templates view
 #269 style(dashboard): update dashboard with new layout
```

### Type

Must be one of the following:

- **feat**: A new feature
- **fix**: A bug fix
- **docs**: Documentation only changes
- **style**: Changes that do not affect the meaning of the code (white-space, formatting, missing
  semi-colons, etc)
- **refactor**: A code change that neither fixes a bug or adds a feature
- **test**: Adding missing tests
- **chore**: Changes to the build process or auxiliary tools and libraries such as documentation
  generation

### Scope

The scope could be anything specifying place of the commit change. For example `networks`,
`dashboard`, `API` etc...

### Subject

The subject contains succinct description of the change:

- use the imperative, present tense: "change" not "changed" nor "changes"
- don't capitalize first letter
- no dot (.) at the end


### Development pre-requisite
1. Java 17
2. Maven build tool
3. Any Editor

### Other notes:
1. use google style formatting