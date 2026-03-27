# WeatherMan
*A Minecraft (bukkit) plugin*

WeatherMan allows you to change biomes and repopulate areas ingame with commands,
magic-wand and a sign, controlled by redstone power.
WorldEdit selections and WorldGuard regions supported.

[**Download**](https://github.com/layertwo/WeatherMan/releases)

[![Java CI](https://github.com/layertwo/WeatherMan/actions/workflows/build.yml/badge.svg)](https://github.com/layertwo/WeatherMan/actions/workflows/build.yml)


## Video

[![CameraObscura Video](http://img.youtube.com/vi/xt57rn_j8KA/mqdefault.jpg)](https://youtu.be/xt57rn_j8KA)

See more videos [here](https://youtu.be/b7SiAiM5V9s?list=PLlAz3KfoBuy_8P3VXNMQ7LT5pgY8ze-S_).

## Features
* Change biomes (you can use: commands, wands, signs, WorldEdit selections and WorldGuard regions)
* Repopulate area according to biome that was previously changed
* Control weather locally: for player, for region, for biome and for whole world.
* Grow trees or cut them off using special wands
* Control biome changing (toggle two biomes) with sign controlled by redstone power.
* Check biome in a your location or inform you about biome changing while you traveling
* Preventing snow-forming and ice-forming in defined biomes.

## Why do I want it?
If you need to change biomes, grow new forest, or going to allow your players to do it - you must install WeatherMan :) If you need to "curse" any player with unstoppable rain you can find this plugin useful too.

## How Do I Install It?
Just copy it in your server `/plugins/` folder.

## How to use it?
* Install
* Use command `/wm set biome:<biome> radius:<radius>` to change biome around you
* Use command `/wm set biome:<biome> to change biome` at area selected using WorldEdit
* Use command `/wm set biome:<biome> region:<region name>` to change biome at WorldGuard region defined by name
* Use command `/wm replace biome:<biome> fill:true` to change biome in your location to new one
* Use command `/wm give [biome | woodcutter | depopulator | forester]` to obtain all or specified wand.
* Use command `/wm wand` to enable wand mode (define biome and radius with commands /wm wand biome:<biome> radius:<radius> tree:<tree type> Right-click with magic wand and you'll shoot the snowball that will change the biome around the hit-point, remove or grow trees.
* Create sign and type `[biome]` in second line, radius value in third, and biome names in first and forth lines. You can set word "replace" in third line if you need to replace the full biome. Now you can use redstone power to toggle between two biomes.

## Commands

### General

| Command | Description |
|---------|-------------|
| `/wm help` | Display help and command list |
| `/wm check` | Check biome at player location |
| `/wm info` | Toggle walk-info mode (notifies player when crossing biome boundaries) |
| `/wm list [tree \| biome name mask]` | List available biome types (or tree types) |
| `/wm wand [biome:<biome> radius:<radius> tree:<tree>]` | Toggle wand mode or configure wand parameters |
| `/wm give <biome \| woodcutter \| depopulator \| forester>` | Give the specified wand |

### Change Biome

| Command | Description |
|---------|-------------|
| `/wm set biome:<biome\|original> radius:<radius>` | Set biome around the player |
| `/wm set biome:<biome\|original> loc:<world,x,z>` | Set biome around a location |
| `/wm set biome:<biome\|original> region:<region>` | Set biome at a WorldGuard region |
| `/wm set biome:<biome\|original>` | Set biome in a WorldEdit selection |
| `/wm set biome:<biome\|original> loc:<world,x,z> loc2:<world,x,z>` | Set biome in area between two locations |

### Replace Biome

| Command | Description |
|---------|-------------|
| `/wm replace biome:<biome\|original> source:<biome> radius:<radius>` | Replace source biome around the player |
| `/wm replace biome:<biome\|original> source:<biome> loc:<world,x,z>` | Replace source biome around a location |
| `/wm replace biome:<biome\|original> source:<biome> region:<region>` | Replace source biome at a WorldGuard region |
| `/wm replace biome:<biome\|original> source:<biome>` | Replace source biome in a WorldEdit selection |
| `/wm replace biome:<biome\|original> source:<biome> loc:<world,x,z> loc2:<world,x,z>` | Replace source biome in area between two locations |
| `/wm replace biome:<biome\|original> fill:true` | Replace current biome at player location |
| `/wm replace biome:<biome\|original> fill:true loc:<world,x,z>` | Replace current biome at a location |

### Repopulate Area

| Command | Description |
|---------|-------------|
| `/wm populate radius:<radius>` | Repopulate area around the player |
| `/wm populate loc:<world,x,z>` | Repopulate area around a location |
| `/wm populate region:<region>` | Repopulate area inside a WorldGuard region |
| `/wm populate` | Repopulate area inside a WorldEdit selection |
| `/wm populate loc:<world,x,z> loc2:<world,x,z>` | Repopulate area between two locations |

### Weather

| Command | Description |
|---------|-------------|
| `/wth player <player> <rain\|clear\|remove>` | Set personal weather for a player |
| `/wth region <region> <rain\|clear\|remove>` | Set weather for a WorldGuard region |
| `/wth biome <biome> <rain\|clear\|remove>` | Set weather for a biome |
| `/wth world <world> <rain\|clear\|remove>` | Set weather for a world |
| `/wth <player\|region\|biome\|world>` | List all overrides for the given scope |

### Local Time

| Command | Description |
|---------|-------------|
| `/wtm player [<player> <HH:MM\|day\|night\|remove>]` | Configure personal time for a player |
| `/wtm region [<region> <HH:MM\|day\|night\|remove>]` | Configure time for a WorldGuard region |
| `/wtm biome [<biome> <HH:MM\|day\|night\|remove>]` | Configure time for a biome |
| `/wtm world [<world> <HH:MM\|day\|night\|remove>]` | Configure time for a world |

### Personal

| Command | Description |
|---------|-------------|
| `/mytime <day\|night\|HH:MM\|remove>` | Set your own personal time override |
| `/myweather <rain\|clear\|remove>` | Set your own personal weather override |

## How to revert back to original biomes
If you need to set back an original biomes at defined area, you can use `original` biome type with commands /wm set, /wm replace, /wm biome (and use wand to change biomes). Command /wm replace source:<source biome> biome:<target biome> supporting "original" only as biome parameter (`<target biome>`).

## Permissions
`weatherman.basic` - allows to use commands `/wm help`, `/wm check`, `/wm list`    
`weatherman.cmdbiome` - allows to use commands `/wm set` and `/wm replace`
`weatherman.sign` - allows to create `[biome]` signs  
`weatherman.wandbiome` - allows to use wand and commands `/wm wand`, `/wm radius`, `/wm biome`  
`weatherman.config` - allows to setup plugin with command `/wm cfg`  
`weatherman.weather` - allows to use local weather command `/wth`
`weatherman.time` - allows to use local time command `/wtm`
`weatherman.myweather` - allows to use personal weather command `/myweather`
`weatherman.mytime` - allows to use personal time command `/mytime`
`weatherman.repopulate` - allows to use repopulate command `/wm populate`

## Update checker and bStats
WeatherMan includes two features that use your server internet connection.
First one is bStats, that used to collect information about the plugin (versions of plugin, of Java.. etc.) and second is update checker, checks new releases of plugin after WeatherMan startup and every half hour. This feature is using API provided by dev.bukkit.org. If you don't like this features you can easy disable it. To disable update checker you need to set parameter "check-updates" to "false" in config.yml. Obtain more information about bStats and learn how to switch off it, you can read [here](https://bstats.org/getting-started).