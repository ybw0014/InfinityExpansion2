package net.guizhanss.infinityexpansion2.implementation.items.groups

import net.guizhanss.infinityexpansion2.InfinityExpansion2
import net.guizhanss.infinityexpansion2.implementation.items.groups.infinity.InfinityDisplayGroup
import net.guizhanss.infinityexpansion2.implementation.items.groups.infinity.InfinityGroup
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

    val SINGULARITIES = SubGroup(
        "singularities".createKey(),
        InfinityExpansion2.localization.getItemGroupItem(
            MaterialType.Material(Material.NETHERITE_BLOCK),
            "singularities"
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

    val INFINITY = InfinityGroup(
        "infinity".createKey(),
        InfinityExpansion2.localization.getItemGroupItem(
            MaterialType.Material(Material.RESPAWN_ANCHOR),
            "infinity"
        )
    )

    val INFINITY_DISPLAY = InfinityDisplayGroup(
        "infinity_display".createKey(),
        InfinityExpansion2.localization.getItemGroupItem(
            MaterialType.Material(Material.RESPAWN_ANCHOR),
            "infinity_display"
        )
    )

    init {
        MAIN.addMenuItem(WikiMenuItem)
        MAIN.addSubGroups(MATERIALS, TOOLS, MACHINES, GENERATORS, SINGULARITIES, MOB_SIMULATION, STORAGE, INFINITY)
        MOB_SIMULATION.isCrossAddonItemGroup = true
        MAIN.register(InfinityExpansion2.instance)
    }
}
