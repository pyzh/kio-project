package io.kurumi.mcio.type

open class Block() {

    companion object {

        val air = "air"
        val 空气 = air

        val stone = "stone"
        val 石头 = stone

        val grass = "grass"
        val 草方块 = grass

        val dirt = "dirt"
        val 泥土 = dirt

        val cobblestone = "cobblestone"
        val 圆石 = cobblestone

        val planks = "planks"
        val 木板 = planks

        val sapling = "sapling"
        val 树苗 = sapling

        val bedrock = "bedrock"
        val 基岩 = bedrock

        val flowing_water = "flowing_water"
        val 水 = flowing_water

        val water = "water"
        val 静态水 = water

        val flowing_lava = "flowing_lava"
        val 熔岩 = flowing_lava

        val lava = "lava"
        val 静态熔岩 = lava

        val sand = "sand"
        val 沙子 = sand

        val gravel = "gravel"
        val 沙砾 = gravel

        val gold_ore = "gold_ore"
        val 金矿石 = gold_ore

        val iron_ore = "iron_ore"
        val 铁矿石 = iron_ore

        val coal_ore = "coal_ore"
        val 煤矿石 = coal_ore

        val log = "print"
        val 木头 = log

        val leaves = "leaves"
        val 树叶 = leaves

        val sponge = "sponge"
        val 海绵 = sponge

        val glass = "glass"
        val 玻璃 = glass

        val lapis_ore = "lapis_ore"
        val 青金石矿石 = lapis_ore

        val lapis_block = "lapis_block"
        val 青金石块 = lapis_block

        val dispenser = "dispenser"
        val 发射器 = dispenser

        val sandstone = "sandstone"
        val 砂岩 = sandstone

        val noteblock = "noteblock"
        val 音符盒 = noteblock

        val bed = "bed"
        val 床 = bed

        val golden_rail = "golden_rail"
        val 充能铁轨 = golden_rail

        val detector_rail = "detector_rail"
        val 探测铁轨 = detector_rail

        val sticky_piston = "sticky_piston"
        val 粘性活塞 = sticky_piston

        val web = "web"
        val 蜘蛛网 = web

        val tallgrass = "tallgrass"
        val 草丛 = tallgrass

        val deadbush = "deadbush"
        val 枯死的灌木 = deadbush

        val piston = "piston"
        val 活塞 = piston

        val pistonarmcollision = "pistonarmcollision"
        val 活塞臂 = pistonarmcollision

        val wool = "wool"
        val 羊毛 = wool

        val yellow_flower = "yellow_flower"
        val 蒲公英 = yellow_flower

        val red_flower = "red_flower"
        val 花 = red_flower

        val brown_mushroom = "brown_mushroom"
        val 棕色蘑菇 = brown_mushroom

        val red_mushroom = "red_mushroom"
        val 红色蘑菇 = red_mushroom

        val gold_block = "gold_block"
        val 金块 = gold_block

        val iron_block = "iron_block"
        val 铁块 = iron_block

        val double_stone_slab = "double_stone_slab"
        val 双石台阶 = double_stone_slab

        val stone_slab = "stone_slab"
        val 石台阶 = stone_slab

        val brick_block = "brick_block"
        val 砖块 = brick_block

        val bookshelf = "bookshelf"
        val 书架 = bookshelf

        val mossy_cobblestone = "mossy_cobblestone"
        val 苔石 = mossy_cobblestone

        val obsidian = "obsidian"
        val 黑曜石 = obsidian

        val torch = "torch"
        val 火把 = torch

        val fire = "fire"
        val 火 = fire

        val mob_spawner = "mob_spawner"
        val 刷怪箱 = mob_spawner

        val oak_stairs = "oak_stairs"
        val 橡木楼梯 = oak_stairs

        val chest = "chest"
        val 箱子 = chest

        val redstone_wire = "redstone_wire"
        val 红石线 = redstone_wire

        val diamond_ore = "diamond_ore"
        val 钻石矿石 = diamond_ore

        val diamond_block = "diamond_block"
        val 钻石块 = diamond_block

        val crafting_table = "crafting_table"
        val 工作台 = crafting_table

        val wheat = "wheat"
        val 小麦 = wheat

        val farmland = "farmland"
        val 耕地 = farmland

        val furnace = "furnace"
        val 熔炉 = furnace

        val lit_furnace = "lit_furnace"
        val 燃烧的熔炉 = lit_furnace

        val standing_sign = "standing_sign"
        val 告示牌 = standing_sign

        val wooden_door = "wooden_door"
        val 木门 = wooden_door

        val ladder = "ladder"
        val 梯子 = ladder

        val rail = "rail"
        val 铁轨 = rail

        val stone_stairs = "stone_stairs"
        val 圆石楼梯 = stone_stairs

        val sign = "sign"
        val 墙上的告示牌 = sign

        val lever = "lever"
        val 拉杆 = lever

        val stone_pressure_plate = "stone_pressure_plate"
        val 石质压力板 = stone_pressure_plate

        val iron_door = "iron_door"
        val 铁门 = iron_door

        val wooden_pressure_plate = "wooden_pressure_plate"
        val 木质压力板 = wooden_pressure_plate

        val redstone_ore = "redstone_ore"
        val 红石矿石 = redstone_ore

        val lit_redstone_ore = "lit_redstone_ore"
        val 点亮的红石矿石 = lit_redstone_ore

        val unlit_redstone_torch = "unlit_redstone_torch"
        val 熄灭的红石火把 = unlit_redstone_torch

        val lit_redstone_torch = "lit_redstone_torch"
        val 红石火把 = lit_redstone_torch

        val stone_button = "stone_button"
        val 石质按钮 = stone_button

        val snow_layer = "snow_layer"
        val 顶层雪 = snow_layer

        val ice = "ice"
        val 冰 = ice

        val snow = "snow"
        val 雪块 = snow

        val cactus = "cactus"
        val 仙人掌 = cactus

        val clay = "clay"
        val 粘土块 = clay

        val reeds = "reeds"
        val 甘蔗 = reeds

        val jukebox = "jukebox"
        val 唱片机 = jukebox

        val fence = "fence"
        val 橡木栅栏 = fence

        val pumpkin = "pumpkin"
        val 南瓜 = pumpkin

        val netherrack = "netherrack"
        val 地狱岩 = netherrack

        val soul_sand = "soul_sand"
        val 灵魂沙 = soul_sand

        val glowstone = "glowstone"
        val 荧石 = glowstone

        val portal = "portal"
        val 下界传送门 = portal

        val lit_pumpkin = "lit_pumpkin"
        val 南瓜灯 = lit_pumpkin

        val cake = "cake"
        val 蛋糕 = cake

        val unpowered_repeater = "unpowered_repeater"
        val 红石中继器 = unpowered_repeater

        val powered_repeater = "powered_repeater"
        val 激活的红石中继器 = powered_repeater

        val invisibleBedrock = "invisibleBedrock"
        val 隐形的基岩 = invisibleBedrock

        val trapdoor = "trapdoor"
        val 活板门 = trapdoor

        val monster_egg = "monster_egg"
        val 怪物蛋 = monster_egg

        val stone_brick = "stone_brick"
        val 石砖 = stone_brick

        val iron_bars = "iron_bars"
        val 铁栏杆 = iron_bars

        val glass_pane = "glass_pane"
        val 玻璃板 = glass_pane

        val melon = "melon"
        val 西瓜 = melon

        val pumpkin_stem = "pumpkin_stem"
        val 南瓜梗 = pumpkin_stem

        val melon_stem = "melon_stem"
        val 西瓜梗 = melon_stem

        val vine = "vine"
        val 藤蔓 = vine

        val fence_gate = "fence_gate"
        val 橡木栅栏门 = fence_gate

        val brick_stairs = "brick_stairs"
        val 砖块楼梯 = brick_stairs

        val stone_brick_stairs = "stone_brick_stairs"
        val 石砖楼梯 = stone_brick_stairs

        val mycelium = "mycelium"
        val 菌丝 = mycelium

        val waterlily = "waterlily"
        val 睡莲 = waterlily

        val nether_brick = "nether_brick"
        val 地狱砖块 = nether_brick

        val nether_brick_fence = "nether_brick_fence"
        val 地狱砖栅栏 = nether_brick_fence

        val nether_brick_stairs = "nether_brick_stairs"
        val 地狱砖楼梯 = nether_brick_stairs

        val nether_wart = "nether_wart"
        val 地狱疣 = nether_wart

        val enchantment_table = "enchantment_table"
        val 附魔台 = enchantment_table

        val brewing_stand = "brewing_stand"
        val 酿造台 = brewing_stand

        val cauldron = "cauldron"
        val 炼药锅 = cauldron

        val end_portal = "end_portal"
        val 末地传送门方块 = end_portal

        val end_portal_frame = "end_portal_frame"
        val 末地传送门框架 = end_portal_frame

        val end_stone = "end_stone"
        val 末地石 = end_stone

        val dragon_egg = "dragon_egg"
        val 龙蛋 = dragon_egg

        val redstone_lamp = "redstone_lamp"
        val 红石灯 = redstone_lamp

        val lit_redstone_lamp = "lit_redstone_lamp"
        val 点亮的红石灯 = lit_redstone_lamp

        val dropper = "dropper"
        val 投掷器 = dropper

        val activator_rail = "activator_rail"
        val 激活铁轨 = activator_rail

        val cocoa = "cocoa"
        val 可可果 = cocoa

        val sandstone_stairs = "sandstone_stairs"
        val 砂岩楼梯 = sandstone_stairs

        val emerald_ore = "emerald_ore"
        val 绿宝石矿石 = emerald_ore

        val ender_chest = "ender_chest"
        val 末影箱 = ender_chest

        val tripwire_hook = "tripwire_hook"
        val 绊线钩 = tripwire_hook

        val tripwire = "tripwire"
        val 绊线 = tripwire

        val emerald_block = "emerald_block"
        val 绿宝石块 = emerald_block

        val spruce_stairs = "spruce_stairs"
        val 云杉楼梯 = spruce_stairs

        val birch_stairs = "birch_stairs"
        val 白桦木楼梯 = birch_stairs

        val jungle_stairs = "jungle_stairs"
        val 丛林楼梯 = jungle_stairs

        val command_block = "command_block"
        val 命令方块 = command_block

        val beacon = "beacon"
        val 信标 = beacon

        val cobblestone_wall = "cobblestone_wall"
        val 圆石墙 = cobblestone_wall

        val flower_pot = "flower_pot"
        val 花盆 = flower_pot

        val carrots = "carrots"
        val 胡萝卜 = carrots

        val potatoes = "potatoes"
        val 马铃薯 = potatoes

        val wooden_button = "wooden_button"
        val 木质按钮 = wooden_button

        val skull = "skull"
        val 生物头颅 = skull

        val anvil = "anvil"
        val 铁砧 = anvil

        val trapped_chest = "trapped_chest"
        val 陷阱箱 = trapped_chest

        val light_weighted_pressure_plate = "light_weighted_pressure_plate"
        val 轻质测重压力板 = light_weighted_pressure_plate

        val heavy_weighted_pressure_plate = "heavy_weighted_pressure_plate"
        val 重质测重压力板 = heavy_weighted_pressure_plate

        val unpowered_comparator = "unpowered_comparator"
        val 红石比较器 = unpowered_comparator

        val powered_comparator = "powered_comparator"
        val 开启的红石比较器 = powered_comparator

        val daylight_detector = "daylight_detector"
        val 阳光传感器 = daylight_detector

        val redstone_block = "redstone_block"
        val 红石块 = redstone_block

        val quartz_ore = "quartz_ore"
        val 下界石英矿石 = quartz_ore

        val hopper = "hopper"
        val 漏斗 = hopper

        val quartz_block = "quartz_block"
        val 石英块 = quartz_block

        val quartz_stairs = "quartz_stairs"
        val 石英楼梯 = quartz_stairs

        val double_wooden_slab = "double_wooden_slab"
        val 双木台阶 = double_wooden_slab

        val wooden_slab = "wooden_slab"
        val 木台阶 = wooden_slab

        val stained_hardened_clay = "stained_hardened_clay"
        val 染色陶瓦 = stained_hardened_clay

        val stained_glass_pane = "stained_glass_pane"
        val 染色玻璃板 = stained_glass_pane

        val leaves2 = "leaves2"
        val 金合欢树叶 = leaves2

        val log2 = "log2"
        val 金合欢木 = log2

        val acacia_wood_stairs = "acacia_wood_stairs"
        val 金合欢楼梯 = acacia_wood_stairs

        val dark_oak_wood_stairs = "dark_oak_wood_stairs"
        val 深色橡木楼梯 = dark_oak_wood_stairs

        val slime_block = "slime_block"
        val 粘液块 = slime_block

        val iron_trapdoor = "iron_trapdoor"
        val 铁活板门 = iron_trapdoor

        val prismarine = "prismarine"
        val 海晶石 = prismarine

        val seaLantern = "seaLantern"
        val 海晶灯 = seaLantern

        val hay_block = "hay_block"
        val 干草块 = hay_block

        val carpet = "carpet"
        val 地毯 = carpet

        val hardened_clay = "hardened_clay"
        val 陶瓦 = hardened_clay

        val coal_block = "coal_block"
        val 煤炭块 = coal_block

        val packed_ice = "packed_ice"
        val 浮冰 = packed_ice

        val double_plant = "double_plant"
        val 向日葵 = double_plant

        val standing_banner = "standing_banner"
        val 站立的旗帜 = standing_banner

        val wall_banner = "wall_banner"
        val 墙上的旗帜 = wall_banner

        val daylight_detector_inverted = "daylight_detector_inverted"
        val 反向阳光传感器 = daylight_detector_inverted

        val red_sandstone = "red_sandstone"
        val 红砂岩 = red_sandstone

        val red_sandstone_stairs = "red_sandstone_stairs"
        val 红砂岩楼梯 = red_sandstone_stairs

        val double_stone_slab2 = "double_stone_slab2"
        val 双红砂岩台阶 = double_stone_slab2

        val sandstone_slab2 = "sandstone_slab2"
        val 红砂岩台阶 = sandstone_slab2

        val spruce_fence_gate = "spruce_fence_gate"
        val 云杉木栅栏门 = spruce_fence_gate

        val birch_fence_gate = "birch_fence_gate"
        val 白桦木栅栏门 = birch_fence_gate

        val jungle_fence_gate = "jungle_fence_gate"
        val 丛林木栅栏门 = jungle_fence_gate

        val dark_oak_fence_gate = "dark_oak_fence_gate"
        val 深色橡木栅栏门 = dark_oak_fence_gate

        val acacia_fence_gate = "acacia_fence_gate"
        val 金合欢栅栏门 = acacia_fence_gate

        val repeating_command_block = "repeating_command_block"
        val 循环型命令方块 = repeating_command_block

        val chain_command_block = "chain_command_block"
        val 连锁型命令方块 = chain_command_block

        val spruce_door = "spruce_door"
        val 云杉木门 = spruce_door

        val birch_door = "birch_door"
        val 白桦木门 = birch_door

        val jungle_door = "jungle_door"
        val 丛林木门 = jungle_door

        val acacia_door = "acacia_door"
        val 金合欢木门 = acacia_door

        val dark_oak_door = "dark_oak_door"
        val 深色橡木门 = dark_oak_door

        val grass_path = "grass_path"
        val 草径 = grass_path

        val frame = "frame"
        val 物品展示框 = frame

        val chorus_flower = "chorus_flower"
        val 紫颂花 = chorus_flower

        val purpur_block = "purpur_block"
        val 紫珀块 = purpur_block

        val purpur_stairs = "purpur_stairs"
        val 紫珀块楼梯 = purpur_stairs

        val undyed_shulker_box = "undyed_shulker_box"
        val 未染色的潜影盒 = undyed_shulker_box

        val end_bricks = "end_bricks"
        val 末地石砖 = end_bricks

        val frosted_ice = "frosted_ice"
        val 霜冰 = frosted_ice

        val end_rod = "end_rod"
        val 末地烛 = end_rod

        val end_gateway = "end_gateway"
        val 末地折跃门方块 = end_gateway

        val magma = "magma"
        val 岩浆块 = magma

        val nether_wart_block = "nether_wart_block"
        val 地狱疣块 = nether_wart_block

        val red_nether_brick = "red_nether_brick"
        val 红色地狱砖块 = red_nether_brick

        val bone_block = "bone_block"
        val 骨块 = bone_block

        val shulker_box = "shulker_box"
        val 潜影盒 = shulker_box

        val purple_glazed_terracotta = "purple_glazed_terracotta"
        val 紫色带釉陶瓦 = purple_glazed_terracotta

        val white_glazed_terracotta = "white_glazed_terracotta"
        val 白色带釉陶瓦 = white_glazed_terracotta

        val orange_glazed_terracotta = "orange_glazed_terracotta"
        val 橙色带釉陶瓦 = orange_glazed_terracotta

        val magenta_glazed_terracotta = "magenta_glazed_terracotta"
        val 品红色带釉陶瓦 = magenta_glazed_terracotta

        val light_blue_glazed_terracotta = "light_blue_glazed_terracotta"
        val 淡蓝色带釉陶瓦 = light_blue_glazed_terracotta

        val yellow_glazed_terracotta = "yellow_glazed_terracotta"
        val 黄色带釉陶瓦 = yellow_glazed_terracotta

        val lime_glazed_terracotta = "lime_glazed_terracotta"
        val 黄绿色带釉陶瓦 = lime_glazed_terracotta

        val pink_glazed_terracotta = "pink_glazed_terracotta"
        val 粉红色带釉陶瓦 = pink_glazed_terracotta

        val gray_glazed_terracotta = "gray_glazed_terracotta"
        val 灰色带釉陶瓦 = gray_glazed_terracotta

        val silver_glazed_terracotta = "silver_glazed_terracotta"
        val 淡灰色带釉陶瓦 = silver_glazed_terracotta

        val cyan_glazed_terracotta = "cyan_glazed_terracotta"
        val 青色带釉陶瓦 = cyan_glazed_terracotta

        val blue_glazed_terracotta = "blue_glazed_terracotta"
        val 蓝色带釉陶瓦 = blue_glazed_terracotta

        val brown_glazed_terracotta = "brown_glazed_terracotta"
        val 棕色带釉陶瓦 = brown_glazed_terracotta

        val green_glazed_terracotta = "green_glazed_terracotta"
        val 绿色带釉陶瓦 = green_glazed_terracotta

        val red_glazed_terracotta = "red_glazed_terracotta"
        val 红色带釉陶瓦 = red_glazed_terracotta

        val black_glazed_terracotta = "black_glazed_terracotta"
        val 黑色带釉陶瓦 = black_glazed_terracotta

        val concrete = "concrete"
        val 混凝土 = concrete

        val concrete_powder = "concrete_powder"
        val 混凝土粉末 = concrete_powder

        val chorus_plant = "chorus_plant"
        val 紫颂植物 = chorus_plant

        val stained_glass = "stained_glass"
        val 染色玻璃 = stained_glass

        val podzol = "podzol"
        val 灰化土 = podzol

        val beetroot = "beetroot"
        val 甜菜根 = beetroot

        val stonecutter = "stonecutter"
        val 切石机 = stonecutter

        val glowingobsidian = "glowingobsidian"
        val 发光的黑曜石 = glowingobsidian

        val nether_reactor_core = "nether_reactor_core"
        val 下界反应核 = nether_reactor_core

        val info_update = "info_update"
        val 数据更新方块 = info_update

        val info_update2 = "info_update2"
        val 数据更新方块2 = info_update2

        val observer = "observer"
        val 侦测器 = observer

        val structure_block = "structure_block"
        val 结构方块 = structure_block

        val reserved6 = "reserved6"
        val 默认方块 = reserved6

        val allow = "allow"
        val 允许方块 = allow

        val deny = "deny"
        val 拒绝方块 = deny

        val border_block = "border_block"
        val 边界方块 = border_block

        val chalkboard = "chalkboard"
        val 黑板 = chalkboard

        val camera = "camera"
        val 相机 = camera

    }
}