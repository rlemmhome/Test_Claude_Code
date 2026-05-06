# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

A minimal Java 25 project managed by IntelliJ IDEA (no build tool — no Maven or Gradle). Source files live in `src/`, compiled output goes to `out/`.

## Build & Run

Compile from the project root:
```
~/.jdks/temurin-25.0.2/bin/javac --enable-preview --release 25 -d out src/*.java
```

Run:
```
~/.jdks/temurin-25.0.2/bin/java --enable-preview -cp out Main
```

Or use IntelliJ's Run/Debug actions directly.

## Tests

Test sources live in `test/`. JUnit 5.11.4 JARs are in `lib/`.

Compile tests (after compiling `src/` first):
```
~/.jdks/temurin-25.0.2/bin/javac --enable-preview --release 25 \
  -cp "out:lib/junit-jupiter-api-5.11.4.jar:lib/opentest4j-1.3.0.jar:lib/junit-platform-commons-1.11.4.jar" \
  -d out test/*.java
```

Run tests:
```
~/.jdks/temurin-25.0.2/bin/java --enable-preview \
  -cp "out:lib/junit-platform-console-standalone-1.11.4.jar" \
  org.junit.platform.console.ConsoleLauncher --select-package=""
```

## Language Features

The project uses **Temurin JDK 25** installed at `~/.jdks/temurin-25.0.2/` (user-local, downloaded by IntelliJ). Uses the unnamed class / instance main method feature:
- Entry point is `void main()` (no `public static`, no `String[] args`)
- `IO.println()` is available in unnamed classes without imports