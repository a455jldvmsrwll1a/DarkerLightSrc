# DarkerLightSrc

![Mod Logo: image of a torch](common/src/main/resources/darkerlightsrc.png)

---

A simple, opinionated mod that makes various light sources darker by capping their maximum light level.
This mod is meant to be used with mods that provide light sources requiring some sort of energy, such as [Create: Power Grid](https://modrinth.com/mod/power-grid).

Somewhat incomplete and is mostly a proof of concept of sorts.

## Planned & In Progress Features

Not sure how actively I will be working on this mod.

- Configuration on Fabric.
- Syncing server config to players with the mod.
- Option to keep the light source's original texture brightness. (i.e. torch appears bright even though it does not propagate a bright light)

## Compatibility

Rules have been added for:

- [Create](https://modrinth.com/mod/create)
- [Create Aeronautics](https://modrinth.com/mod/create-aeronautics)
- [Create: Bits 'n' Bobs](https://modrinth.com/mod/create-bits-n-bobs)
- [Create: Connected](https://modrinth.com/mod/create-connected)
- [Create Crafts & Additions](https://modrinth.com/mod/createaddition) (brightness unchanged)
- [Create: Design 'n' Decor](https://modrinth.com/mod/create-design-n-decor)
- [Create: Power Grid](https://modrinth.com/mod/power-grid) (brightness unchanged)
- [Create: Prismatic Shine](https://modrinth.com/mod/create-prismatic-shine)
- [Create Propulsion: Simulated](https://modrinth.com/mod/create-propulsion-simulated)
- [Hardcore Torches](https://modrinth.com/mod/hardcore-torches)
- [Thick Air](https://modrinth.com/mod/thick-air)

I plan to add support for more mods as I come across them.

## Building (todo)

Open a shell on the project directory and run `./gradlew build` on Mac & Linux, or `gradlew.bat build` on Windows.

You can find the emitted JARs in `fabric/build/libs/` and `neoforge/build/libs/`.
