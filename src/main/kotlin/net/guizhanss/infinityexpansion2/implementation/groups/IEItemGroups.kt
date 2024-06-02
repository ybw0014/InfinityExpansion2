package net.guizhanss.infinityexpansion2.implementation.groups

import net.guizhanss.infinityexpansion2.InfinityExpansion2
import net.guizhanss.infinityexpansion2.utils.createKey
import net.guizhanss.infinityexpansion2.utils.items.MaterialType
import org.bukkit.Material

object IEItemGroups {
    val MAIN = MainGroup(
        "main".createKey(),
        InfinityExpansion2.localization.getItemGroupItem(
            MaterialType.Material(Material.NETHER_STAR),
            "main"
        )
    )

    val MATERIALS = SubGroup(
        "materials".createKey(),
        InfinityExpansion2.localization.getItemGroupItem(
            MaterialType.Material(Material.NETHER_STAR),
            "materials"
        )
    )

    val SINGULARITIES = SubGroup(
        "singularities".createKey(),
        InfinityExpansion2.localization.getItemGroupItem(
            MaterialType.Material(Material.NETHERITE_BLOCK),
            "singularities"
        )
    )

    val SLIMEFUN_EXPANSION = SubGroup(
        "slimefun_expansion".createKey(),
        InfinityExpansion2.localization.getItemGroupItem(
            MaterialType.Material(Material.SLIME_BLOCK),
            "slimefun_expansion"
        )
    )

    val TOOLS = SubGroup(
        "tools".createKey(),
        InfinityExpansion2.localization.getItemGroupItem(
            MaterialType.Material(Material.DIAMOND_PICKAXE),
            "tools"
        )
    )

    val MACHINES = SubGroup(
        "machines".createKey(),
        InfinityExpansion2.localization.getItemGroupItem(
            MaterialType.Material(Material.LOOM),
            "machines"
        )
    )

    val GENERATORS = SubGroup(
        "generators".createKey(),
        InfinityExpansion2.localization.getItemGroupItem(
            MaterialType.Material(Material.BLAST_FURNACE),
            "generators"
        )
    )

    val GEARS = SubGroup(
        "gears".createKey(),
        InfinityExpansion2.localization.getItemGroupItem(
            MaterialType.Material(Material.DIAMOND_CHESTPLATE),
            "gears"
        )
    )

    val MOB_SIMULATION = SubGroup(
        "mob_simulation".createKey(),
        InfinityExpansion2.localization.getItemGroupItem(
            MaterialType.Material(Material.BEACON),
            "mob_simulation"
        )
    )

    val STORAGE = SubGroup(
        "storage".createKey(),
        InfinityExpansion2.localization.getItemGroupItem(
            MaterialType.Material(Material.BEEHIVE),
            "storage"
        )
    )

    init {
        // TODO: Guide group
        MAIN.addSubGroups(
            MATERIALS,
            SINGULARITIES,
            SLIMEFUN_EXPANSION,
            TOOLS,
            MACHINES,
            GENERATORS,
            GEARS,
            MOB_SIMULATION,
            STORAGE,
        )
        MOB_SIMULATION.isCrossAddonItemGroup = true
        MAIN.register(InfinityExpansion2.instance)
    }
}