package pl.minehostAgent;


import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pl.minehostAgent.manager.DataManager;

import java.util.logging.Level;

public final class Main extends JavaPlugin {
    boolean enabledSuccessfully = true;

    @Override
    public void onLoad() {
        if (!Bukkit.getServer().getVersion().contains("1.15") && !Bukkit.getServer().getVersion().contains("1.14")) {
            this.enabledSuccessfully = false;
        }
        DataManager dataManager = new DataManager(this, "bukkit.yml", "spigot.yml", "paper.yml");
        dataManager.saveDefaultSettings();
        dataManager.loadConfigurations();
        dataManager.loadDataFromConfig();
    }

    @Override
    public void onEnable() {
        if (!enabledSuccessfully) {
            this.getLogger().log(Level.SEVERE, "Wersja " + Bukkit.getServer().getVersion() + " nie jest wspierana!");
            this.setEnabled(false);
        }
    }
}
