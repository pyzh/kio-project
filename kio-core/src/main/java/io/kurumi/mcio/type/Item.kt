package io.kurumi.mcio.type

open class Item : Block() {

    companion object {

        val iron_shovel = "iron_shovel"
        val 铁锹 = iron_shovel

        val iron_pickaxe = "iron_pickaxe"
        val 铁镐 = iron_pickaxe

        val iron_axe = "iron_axe"
        val 铁斧 = iron_axe

        val flint_and_steel = "flint_and_steel"
        val 打火石 = flint_and_steel

        val apple = "apple"
        val 苹果 = apple

        val bow = "bow"
        val 弓 = bow

        val arrow = "arrow"
        val 箭 = arrow

        val coal = "coal"
        val 煤炭 = coal

        val diamond = "diamond"
        val 钻石 = diamond

        val iron_ingot = "iron_ingot"
        val 铁锭 = iron_ingot

        val gold_ingot = "gold_ingot"
        val 金锭 = gold_ingot

        val iron_sword = "iron_sword"
        val 铁剑 = iron_sword

        val wooden_sword = "wooden_sword"
        val 木剑 = wooden_sword

        val wooden_shovel = "wooden_shovel"
        val 木锹 = wooden_shovel

        val wooden_pickaxe = "wooden_pickaxe"
        val 木镐 = wooden_pickaxe

        val wooden_axe = "wooden_axe"
        val 木斧 = wooden_axe

        val stone_sword = "stone_sword"
        val 石剑 = stone_sword

        val stone_shovel = "stone_shovel"
        val 石锹 = stone_shovel

        val stone_pickaxe = "stone_pickaxe"
        val 石镐 = stone_pickaxe

        val stone_axe = "stone_axe"
        val 石斧 = stone_axe

        val diamond_sword = "diamond_sword"
        val 钻石剑 = diamond_sword

        val diamond_shovel = "diamond_shovel"
        val 钻石锹 = diamond_shovel

        val diamond_pickaxe = "diamond_pickaxe"
        val 钻石镐 = diamond_pickaxe

        val diamond_axe = "diamond_axe"
        val 钻石斧 = diamond_axe

        val stick = "stick"
        val 木棍 = stick

        val bowl = "bowl"
        val 碗 = bowl

        val mushroom_stew = "mushroom_stew"
        val 蘑菇煲 = mushroom_stew

        val golden_sword = "golden_sword"
        val 金剑 = golden_sword

        val golden_shovel = "golden_shovel"
        val 金锹 = golden_shovel

        val golden_pickaxe = "golden_pickaxe"
        val 金镐 = golden_pickaxe

        val golden_axe = "golden_axe"
        val 金斧 = golden_axe

        val string = "string"
        val 线 = string

        val feather = "feather"
        val 羽毛 = feather

        val gunpowder = "gunpowder"
        val 火药 = gunpowder

        val wooden_hoe = "wooden_hoe"
        val 木锄 = wooden_hoe

        val stone_hoe = "stone_hoe"
        val 石锄 = stone_hoe

        val iron_hoe = "iron_hoe"
        val 铁锄 = iron_hoe

        val diamond_hoe = "diamond_hoe"
        val 钻石锄 = diamond_hoe

        val golden_hoe = "golden_hoe"
        val 金锄 = golden_hoe

        val seeds = "seeds"
        val 小麦种子 = seeds

        val wheat = "wheat"
        val 小麦 = wheat

        val bread = "bread"
        val 面包 = bread

        val leather_cap = "leather_cap"
        val 皮革帽子 = leather_cap

        val leather_tunic = "leather_tunic"
        val 皮革外套 = leather_tunic

        val leather_pants = "leather_pants"
        val 皮革裤子 = leather_pants

        val leather_boots = "leather_boots"
        val 皮革靴子 = leather_boots

        val chain_helmet = "chain_helmet"
        val 锁链头盔 = chain_helmet

        val chain_chestplate = "chain_chestplate"
        val 锁链胸甲 = chain_chestplate

        val chain_leggings = "chain_leggings"
        val 锁链护腿 = chain_leggings

        val chain_boots = "chain_boots"
        val 锁链靴子 = chain_boots

        val iron_helmet = "iron_helmet"
        val 铁头盔 = iron_helmet

        val iron_chestplate = "iron_chestplate"
        val 铁胸甲 = iron_chestplate

        val iron_leggings = "iron_leggings"
        val 铁护腿 = iron_leggings

        val iron_boots = "iron_boots"
        val 铁靴子 = iron_boots

        val diamond_helmet = "diamond_helmet"
        val 钻石头盔 = diamond_helmet

        val diamond_chestplate = "diamond_chestplate"
        val 钻石胸甲 = diamond_chestplate

        val diamond_leggings = "diamond_leggings"
        val 钻石护腿 = diamond_leggings

        val diamond_boots = "diamond_boots"
        val 钻石靴子 = diamond_boots

        val golden_helmet = "golden_helmet"
        val 金头盔 = golden_helmet

        val golden_chestplate = "golden_chestplate"
        val 金胸甲 = golden_chestplate

        val golden_leggings = "golden_leggings"
        val 金护腿 = golden_leggings

        val golden_boots = "golden_boots"
        val 金靴子 = golden_boots

        val flint = "flint"
        val 燧石 = flint

        val raw_porkchop = "raw_porkchop"
        val 生猪排 = raw_porkchop

        val cooked_porkchop = "cooked_porkchop"
        val 熟猪排 = cooked_porkchop

        val painting = "painting"
        val 画 = painting

        val golden_apple = "golden_apple"
        val 金苹果 = golden_apple

        val sign = "sign"
        val 告示牌 = sign

        val wooden_door = "wooden_door"
        val 木门 = wooden_door

        val bucket = "bucket"
        val 桶 = bucket

        val minecart = "minecart"
        val 矿车 = minecart

        val saddle = "saddle"
        val 鞍 = saddle

        val iron_door = "iron_door"
        val 铁门 = iron_door

        val redstone = "redstone"
        val 红石粉 = redstone

        val snowball = "snowball"
        val 雪球 = snowball

        val boat = "boat"
        val 船 = boat

        val leather = "leather"
        val 皮革 = leather

        val brick = "brick"
        val 红砖 = brick

        val clay = "clay"
        val 粘土 = clay

        val sugar_cane = "sugar_cane"
        val 甘蔗 = sugar_cane

        val paper = "paper"
        val 纸 = paper

        val book = "book"
        val 书 = book

        val slimeball = "slimeball"
        val 粘液球 = slimeball

        val chest_minecart = "chest_minecart"
        val 运输矿车 = chest_minecart

        val egg = "egg"
        val 鸡蛋 = egg

        val compass = "compass"
        val 指南针 = compass

        val fishing_rod = "fishing_rod"
        val 钓鱼竿 = fishing_rod

        val clock = "clock"
        val 钟 = clock

        val glowstone_dust = "glowstone_dust"
        val 荧石粉 = glowstone_dust

        val fish = "fish"
        val 生鱼 = fish

        val cooked_fish = "cooked_fish"
        val 熟鱼 = cooked_fish

        val dye = "dye"
        val 染料 = dye

        val bone = "bone"
        val 骨头 = bone

        val sugar = "sugar"
        val 糖 = sugar

        val cake = "cake"
        val 蛋糕 = cake

        val bed = "bed"
        val 床 = bed

        val redstone_repeater = "redstone_repeater"
        val 红石中继器 = redstone_repeater

        val cookie = "cookie"
        val 曲奇 = cookie

        val map_filled = "map_filled"
        val 地图 = map_filled

        val shears = "shears"
        val 剪刀 = shears

        val melon = "melon"
        val 西瓜片 = melon

        val pumpkin_seeds = "pumpkin_seeds"
        val 南瓜种子 = pumpkin_seeds

        val melon_seeds = "melon_seeds"
        val 西瓜种子 = melon_seeds

        val beef = "beef"
        val 生牛肉 = beef

        val cooked_beef = "cooked_beef"
        val 牛排 = cooked_beef

        val chicker = "chicker"
        val 生鸡肉 = chicker

        val cooked_chicken = "cooked_chicken"
        val 熟鸡肉 = cooked_chicken

        val rotten_flesh = "rotten_flesh"
        val 腐肉 = rotten_flesh

        val ender_pearl = "ender_pearl"
        val 末影珍珠 = ender_pearl

        val blaze_rod = "blaze_rod"
        val 烈焰棒 = blaze_rod

        val ghast_tear = "ghast_tear"
        val 恶魂之泪 = ghast_tear

        val gold_nugget = "gold_nugget"
        val 金粒 = gold_nugget

        val nether_wart = "nether_wart"
        val 地狱疣 = nether_wart

        val potion = "potion"
        val 药水 = potion

        val glass_bottle = "glass_bottle"
        val 玻璃瓶 = glass_bottle

        val spider_eye = "spider_eye"
        val 蜘蛛眼 = spider_eye

        val fermented_spider_eye = "fermented_spider_eye"
        val 发酵蛛眼 = fermented_spider_eye

        val blaze_powder = "blaze_powder"
        val 烈焰粉 = blaze_powder

        val magma_cream = "magma_cream"
        val 岩浆膏 = magma_cream

        val brewing_stand = "brewing_stand"
        val 酿造台 = brewing_stand

        val cauldron = "cauldron"
        val 炼药锅 = cauldron

        val ender_eye = "ender_eye"
        val 末影之眼 = ender_eye

        val speckled_melon = "speckled_melon"
        val 闪烁的西瓜 = speckled_melon

        val spawn_egg = "spawn_egg"
        val 刷怪蛋 = spawn_egg

        val xp_bottle = "xp_bottle"
        val 附魔之瓶 = xp_bottle

        val fireball = "fireball"
        val 火焰弹 = fireball

        val writable_book = "writable_book"
        val 书与笔 = writable_book

        val written_book = "written_book"
        val 成书 = written_book

        val emerald = "emerald"
        val 绿宝石 = emerald

        val frame = "frame"
        val 物品展示框 = frame

        val flower_pot = "flower_pot"
        val 花盆 = flower_pot

        val carrot = "carrot"
        val 胡萝卜 = carrot

        val potato = "potato"
        val 马铃薯 = potato

        val baked_potato = "baked_potato"
        val 烤马铃薯 = baked_potato

        val poisonous_potato = "poisonous_potato"
        val 毒马铃薯 = poisonous_potato

        val emptymap = "emptymap"
        val 空地图 = emptymap

        val golden_carrot = "golden_carrot"
        val 金胡萝卜 = golden_carrot

        val skull = "skull"
        val 生物头颅 = skull

        val carrot_on_a_stick = "carrot_on_a_stick"
        val 胡萝卜钓竿 = carrot_on_a_stick

        val netherStar = "netherStar"
        val 下界之星 = netherStar

        val pumpkin_pie = "pumpkin_pie"
        val 南瓜派 = pumpkin_pie

        val firework_rocket = "firework_rocket"
        val 烟花火箭 = firework_rocket

        val fireworksCharge = "fireworksCharge"
        val 烟火之星 = fireworksCharge

        val enchanted_book = "enchanted_book"
        val 附魔书 = enchanted_book

        val comparator = "comparator"
        val 红石比较器 = comparator

        val netherbrick = "netherbrick"
        val 地狱砖块 = netherbrick

        val quartz = "quartz"
        val 下界石英 = quartz

        val tnt_minecart = "tnt_minecart"
        val TNT矿车 = tnt_minecart

        val hopper_minecart = "hopper_minecart"
        val 漏斗矿车 = hopper_minecart

        val prismarine_shard = "prismarine_shard"
        val 海晶碎片 = prismarine_shard

        val hopper = "hopper"
        val 漏斗 = hopper

        val rabbit = "rabbit"
        val 生兔肉 = rabbit

        val cooked_rabbit = "cooked_rabbit"
        val 熟兔肉 = cooked_rabbit

        val rabbit_stew = "rabbit_stew"
        val 兔肉煲 = rabbit_stew

        val rabbit_foot = "rabbit_foot"
        val 兔子脚 = rabbit_foot

        val rabbit_hide = "rabbit_hide"
        val 兔子皮 = rabbit_hide

        val horsearmorleather = "horsearmorleather"
        val 皮革马铠 = horsearmorleather

        val horsearmoriron = "horsearmoriron"
        val 铁马铠 = horsearmoriron

        val horsearmorgold = "horsearmorgold"
        val 金马铠 = horsearmorgold

        val horsearmordiamond = "horsearmordiamond"
        val 钻石马铠 = horsearmordiamond

        val lead = "lead"
        val 拴绳 = lead

        val nametag = "nametag"
        val 命名牌 = nametag

        val prismarine_crystals = "prismarine_crystals"
        val 海晶砂粒 = prismarine_crystals

        val muttonraw = "muttonraw"
        val 生羊肉 = muttonraw

        val muttoncooked = "muttoncooked"
        val 熟羊肉 = muttoncooked

        val armor_stand = "armor_stand"
        val 盔甲架 = armor_stand

        val end_crystal = "end_crystal"
        val 末影水晶 = end_crystal

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

        val chorus_fruit = "chorus_fruit"
        val 紫颂果 = chorus_fruit

        val chorus_fruit_popped = "chorus_fruit_popped"
        val 爆裂紫颂果 = chorus_fruit_popped

        val dragon_breath = "dragon_breath"
        val 龙息 = dragon_breath

        val splash_potion = "splash_potion"
        val 喷溅药水 = splash_potion

        val lingering_potion = "lingering_potion"
        val 滞留药水 = lingering_potion

        val command_block_minecart = "command_block_minecart"
        val 命令方块矿车 = command_block_minecart

        val elytra = "elytra"
        val 鞘翅 = elytra

        val shulker_shell = "shulker_shell"
        val 潜影壳 = shulker_shell

        val banner = "banner"
        val 旗帜 = banner

        val totem = "totem"
        val 不死图腾 = totem

        val iron_nugget = "iron_nugget"
        val 铁粒 = iron_nugget

        val beetroot = "beetroot"
        val 甜菜根 = beetroot

        val beetroot_seeds = "beetroot_seeds"
        val 甜菜种子 = beetroot_seeds

        val beetroot_soup = "beetroot_soup"
        val 甜菜汤 = beetroot_soup

        val salmon = "salmon"
        val 生鲑鱼 = salmon

        val clownfish = "clownfish"
        val 小丑鱼 = clownfish

        val pufferfish = "pufferfish"
        val 河豚 = pufferfish

        val cooked_salmon = "cooked_salmon"
        val 熟鲑鱼 = cooked_salmon

        val appleenchanted = "appleenchanted"
        val 附魔金苹果 = appleenchanted

        val record_13 = "record_13"
        val 唱片13 = record_13

        val record_cat = "record_cat"
        val 唱片cat = record_cat

        val record_blocks = "record_blocks"
        val 唱片blocks = record_blocks

        val record_chirp = "record_chirp"
        val 唱片chirp = record_chirp

        val record_far = "record_far"
        val 唱片far = record_far

        val record_mall = "record_mall"
        val 唱片mall = record_mall

        val record_mellohi = "record_mellohi"
        val 唱片mellohi = record_mellohi

        val record_stal = "record_stal"
        val 唱片stal = record_stal

        val record_strad = "record_strad"
        val 唱片strad = record_strad

        val record_ward = "record_ward"
        val 唱片ward = record_ward

        val record_11 = "record_11"
        val 唱片11 = record_11

        val record_wait = "record_wait"
        val wait唱片 = record_wait

        val chalkboard = "chalkboard"
        val 黑板 = chalkboard

        val portfolio = "portfolio"
        val 公文包 = portfolio

        val camera = "camera"
        val 相机 = camera

    }

}