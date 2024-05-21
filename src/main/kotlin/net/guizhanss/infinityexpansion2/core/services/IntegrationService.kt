package net.guizhanss.infinityexpansion2.core.services

import net.guizhanss.infinityexpansion2.InfinityExpansion2
import net.guizhanss.slimefuntranslation.api.SlimefunTranslationAPI
import net.guizhanss.slimefuntranslation.api.config.TranslationConfiguration
import net.guizhanss.slimefuntranslation.api.config.TranslationConfigurationDefaults
import net.guizhanss.slimefuntranslation.api.config.TranslationConfigurationFields
import net.guizhanss.slimefuntranslation.utils.FileUtils
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.entity.Player
import java.io.File

class IntegrationService(private val plugin: InfinityExpansion2) {
    var slimefunTranslationEnabled = false
        private set

    init {
        slimefunTranslationEnabled = isPluginEnabled("SlimefunTranslation")
    }

    private fun isPluginEnabled(pluginName: String) = plugin.server.pluginManager.isPluginEnabled(pluginName)

    fun loadTranslations() {
        val fields = TranslationConfigurationFields.builder().items("items").lore("lores").build()
        val defaults = TranslationConfigurationDefaults.builder().name("InfinityExpansion2").build()
        val languages = FileUtils.listYamlFiles(File(plugin.dataFolder, "lang"))
        for (langFile in languages) {
            val file = File(plugin.dataFolder, "lang" + File.separator + langFile)
            val lang = langFile.replace(".yml", "")
            val fileConfig = YamlConfiguration.loadConfiguration(file)
            val cfg = TranslationConfiguration.fromFileConfiguration(lang, fileConfig, fields, defaults)
            cfg.ifPresent { it.register(plugin) }
        }
    }

    fun getLore(p: Player, id: String) =
        if (slimefunTranslationEnabled) {
            SlimefunTranslationAPI.getLore(SlimefunTranslationAPI.getUser(p), id, true)
        } else {
            InfinityExpansion2.localization.getLore(id)
        }
}