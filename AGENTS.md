# WeatherMan — Agent Guidance

## Build

```bash
mvn package
```

JAR is produced at `target/WeatherMan-<version>.jar`.

## Test

```bash
mvn test
```

Tests live in `src/test/java/`. Only pure-logic classes (no Bukkit server required) are tested directly. Classes requiring a running Bukkit server need MockBukkit or an integration test harness.

## Branch

Main branch is `mainline`. PRs target `mainline`.

## Key Structure

- `src/main/java/me/fromgate/weatherman/` — plugin source
  - `commands/` — command handlers (abstract `Cmd` base + `@CmdDefine` annotation)
  - `localweather/` — per-player/region/biome/world weather state
  - `localtime/` — per-player/region/biome/world time state
  - `playerconfig/` — per-player brush/wand/weather/time persistence
  - `queue/` — async biome block update queue
  - `util/` — configuration (`Cfg`), biome tools, WorldEdit/WorldGuard wrapper
- `src/main/resources/` — `plugin.yml`, `config.yml`, `lang/*.lng`

## Dependencies

- Spigot API (provided at runtime — do not shade)
- WorldEdit + WorldGuard (provided — soft dependency)
- bStats shaded and relocated under `me.fromgate.weatherman.bstats`
