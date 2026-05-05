# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

A minimal Java 25 project managed by IntelliJ IDEA (no build tool — no Maven or Gradle). Source files live in `src/`, compiled output goes to `out/`.

## Build & Run

Compile from the project root:
```
javac -d out src/Main.java
```

Run:
```
java -cp out Main
```

Or use IntelliJ's Run/Debug actions directly.

## Language Features

The project targets **JDK 25 (Temurin)** and uses the unnamed class / instance main method preview feature introduced in Java 21+:
- Entry point is `void main()` (no `public static`, no `String[] args`)
- `IO.println()` is available in unnamed classes without imports