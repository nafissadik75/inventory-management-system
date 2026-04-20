# 🛒 Inventory & Shop Management System

A terminal-based Java application for managing inventory and shop operations. Built as a 10-week academic team project.

---

## 📋 Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Getting Started](#getting-started)
- [Development Workflow](#development-workflow)
- [CI/CD](#cicd)
- [Milestones](#milestones)

---

## Project Overview

This is a command-line Java application that simulates a shop and inventory management system. Users can manage products, track stock levels, process transactions, and generate basic reports — all from the terminal.

---


## Features

> Features are being built incrementally over 10 weeks. Checked items are complete.

- [ ] Core data model (Product, Inventory)
- [ ] Add / remove products
- [ ] Update stock levels
- [ ] Search and filter inventory
- [ ] Basic transaction processing
- [ ] Sales reporting
- [ ] User input validation
- [ ] Persistent data storage
- [ ] Error handling & edge cases
- [ ] Final integration & polish

---

## Getting Started

### Prerequisites

- Java JDK 17 or higher installed
- Git installed

### Clone the Repository

```bash
git clone https://github.com/<your-org>/<repo-name>.git
cd <repo-name>
```

### Run the Application

```bash
# Compile
javac -d out src/**/*.java

# Run
java -cp out Main
```

---

## Development Workflow

We follow a **feature branch workflow**:

1. Pick a task from the project board
2. Create a branch: `git checkout -b feature/<short-description>`
3. Make your changes and commit often
4. Push your branch: `git push origin feature/<short-description>`
5. Open a Pull Request (PR) on GitHub
6. Wait for review, then merge into `main`

### Branch Naming Convention

| Type      | Format                        | Example                    |
|-----------|-------------------------------|----------------------------|
| Feature   | `feature/<description>`       | `feature/add-product`      |
| Bug Fix   | `fix/<description>`           | `fix/stock-update-crash`   |
| Docs      | `docs/<description>`          | `docs/update-readme`       |

### Commit Message Style

```
<type>: <short summary>

Examples:
feat: add product search by name
fix: handle negative stock input
docs: update README with setup steps
```

> `main` is a **protected branch** — direct pushes are disabled. All changes must go through a PR.

---

## CI/CD

This project uses **GitHub Actions** for continuous integration. On every push and PR to `main`, the pipeline will:

- Compile the Java source code
- Run all unit tests
- Report pass/fail status on the PR

Configuration lives in `.github/workflows/`.

---

## Milestones

| Milestone | Description                        | Status      |
|-----------|------------------------------------|-------------|
| M0        | Repo setup, structure, CI config   | Done        |
| M1        | Core data model                    | Ongoing     |
| M2        | Basic CRUD operations              | ⏳ Pending  |
| M3        | Terminal UI & navigation           | ⏳ Pending  |
| M4        | Persistence & data storage         | ⏳ Pending  |
| M5        | Reporting & final polish           | ⏳ Pending  |

---

## License

This project is for academic purposes only.
