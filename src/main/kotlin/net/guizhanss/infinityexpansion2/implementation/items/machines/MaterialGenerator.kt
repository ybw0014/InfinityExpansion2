package net.guizhanss.infinityexpansion2.implementation.items.machines

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack
import io.github.thebusybiscuit.slimefun4.api.items.settings.IntRangeSetting
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu
import net.guizhanss.infinityexpansion2.InfinityExpansion2
import net.guizhanss.infinityexpansion2.core.menu.MenuLayout
import net.guizhanss.infinityexpansion2.utils.items.GuiItems
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class MaterialGenerator(
    itemGroup: ItemGroup,
    itemStack: SlimefunItemStack,
    recipeType: RecipeType,
    recipe: Array<out ItemStack?>,
    val material: Material,
    val speed: Int,
    energyPerTick: Int,
) : AbstractMachine(itemGroup, itemStack, recipeType, recipe, MenuLayout.OUTPUT_ONLY_ONE_ROW), RecipeDisplayItem {
    private val tickRateSetting = IntRangeSetting(this, "tick-rate", 1, 1, 120)
    private val energyPerTickSetting = IntRangeSetting(this, "energy-per-tick", 1, energyPerTick, 1_000_000_000)

    init {
        addItemSetting(tickRateSetting, energyPerTickSetting)
    }

    override fun getEnergyConsumptionPerTick() = energyPerTickSetting.value

    override fun process(b: Block, menu: BlockMenu): Boolean {
        val output = ItemStack(material, speed)
        if (menu.fits(output, *outputSlots)) {
            if (menu.hasViewer()) {
                menu.replaceExistingItem(layout.statusSlot, GuiItems.NO_SPACE)
            }
            return false
        }

        if (menu.hasViewer()) {
            menu.replaceExistingItem(layout.statusSlot, GuiItems.PRODUCING)
        }

        if (InfinityExpansion2.sfTickCount() % tickRateSetting.value == 0) {
            menu.pushItem(output, *outputSlots)
        }
        return true
    }

    override fun getRecipeSectionLabel(p: Player) = InfinityExpansion2.integrationService.getLore(p, "info")

    override fun getDisplayRecipes() = listOf(
        GuiItems.tickRate(tickRateSetting.value),
        GuiItems.energyConsumption(energyPerTickSetting.value),
        GuiItems.PRODUCES,
        GuiItems.PRODUCES,
        ItemStack(material, speed)
    )
}
