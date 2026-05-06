# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

A minimal Java 25 project managed by IntelliJ IDEA (no build tool — no Maven or Gradle). Source files live in `src/`, compiled output goes to `out/`.

## Build & Run

Compile from the project root:
```
javac --enable-preview --release 21 -d out src/Main.java
```

Run:
```
java --enable-preview -cp out Main
```

Or use IntelliJ's Run/Debug actions directly.

## Language Features

The project targets **JDK 25 (Temurin)** but the system has **JDK 21 (Temurin)** installed. Uses the unnamed class / instance main method preview feature:
- Entry point is `void main()` (no `public static`, no `String[] args`)
- Use `System.out.println()` — `IO.println()` requires Java 23+