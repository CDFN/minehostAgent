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
    private final Map<String, FileConfiguration> serversConfiguration = new HashMap<>();
    private final Map<String, FileConfiguration> pluginsConfiguration = new HashMap<>();

    public DataManager(Main plugin, String... filesToLoad) {
        this.plugin = plugin;
        for (String fileName : filesToLoad) {
            serversConfiguration.put(fileName, YamlConfiguration.loadConfiguration(new File(fileName)));
            pluginsConfiguration.put(fileName, YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), fileName)));
            plugin.saveResource(fileName, false);
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

        System.out.println();
        System.out.println(ChatColor.GREEN + "           _      ___                   _   \n");
        System.out.println(ChatColor.GREEN + "          | |    / _ \\                 | |  \n");
        System.out.println(ChatColor.GREEN + " _ __ ___ | |__ / /_\\ \\ __ _  ___ _ __ | |_ \n");
        System.out.println(ChatColor.GREEN + "| '_ ` _ \\| '_ \\|  _  |/ _` |/ _ \\ '_ \\| __|\n");
        System.out.println(ChatColor.GREEN + "| | | | | | | | | | | | (_| |  __/ | | | |_ \n");
        System.out.println(ChatColor.GREEN + "|_| |_| |_|_| |_\\_| |_/\\__, |\\___|_| |_|\\__|\n");
        System.out.println(ChatColor.GREEN + "                        __/ |               \n");
        System.out.println(ChatColor.GREEN + "                       |___/                ");
        System.out.println();
        System.out.println(ChatColor.GREEN + " Domyślne ustawienia serwera zalecane przez MINEHOST.PL zostały pomyślnie załadowane.");

    }
}
