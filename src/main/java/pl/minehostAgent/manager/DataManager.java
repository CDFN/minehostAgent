package pl.minehostAgent.manager;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import pl.minehostAgent.Main;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class DataManager {
    private final Main plugin;
    private final String[] filesToLoad;
    private final Map<String, FileConfiguration> serversConfiguration = new HashMap<>();
    private final Map<String, FileConfiguration> pluginsConfiguration = new HashMap<>();

    public DataManager(Main plugin, String... filesToLoad) {
        this.plugin = plugin;
        this.filesToLoad = filesToLoad;
    }

    public void saveDefaultSettings() {
        for (String fileName : filesToLoad) {
            plugin.saveResource(fileName, false);
        }
    }

    public void loadConfigurations() {
        for (String fileName : filesToLoad) {
            serversConfiguration.put(fileName, YamlConfiguration.loadConfiguration(new File(fileName)));
            pluginsConfiguration.put(fileName, YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), fileName)));
        }
    }

    public void loadDataFromConfig() {
        this.pluginsConfiguration.forEach((fileName, config) -> {
            config.getKeys(true).forEach(key -> serversConfiguration.get(fileName).set(key, config.get(key)));

            try {
                serversConfiguration.get(fileName).save(fileName);
            } catch (IOException e) {
                plugin.getLogger().log(Level.WARNING, "Failed to save " + fileName);
                e.printStackTrace();
            }
        });

        plugin.getLogger().log(Level.INFO, "           _      ___                   _   \n");
        plugin.getLogger().log(Level.INFO, "          | |    / _ \\                 | |  \n");
        plugin.getLogger().log(Level.INFO, " _ __ ___ | |__ / /_\\ \\ __ _  ___ _ __ | |_ \n");
        plugin.getLogger().log(Level.INFO, "| '_ ` _ \\| '_ \\|  _  |/ _` |/ _ \\ '_ \\| __|\n");
        plugin.getLogger().log(Level.INFO, "| | | | | | | | | | | | (_| |  __/ | | | |_ \n");
        plugin.getLogger().log(Level.INFO, "|_| |_| |_|_| |_\\_| |_/\\__, |\\___|_| |_|\\__|\n");
        plugin.getLogger().log(Level.INFO, "                        __/ |               \n");
        plugin.getLogger().log(Level.INFO, "                       |___/                ");
        plugin.getLogger().log(Level.INFO, " Domyślne ustawienia serwera zalecane przez MINEHOST.PL zostały pomyślnie załadowane.");
    }
}
