package pl.minehostAgent;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import pl.minehostAgent.manager.DataManager;

public final class Main extends JavaPlugin {

    @Override
    public void onLoad() {
        if (!Bukkit.getServer().getVersion().contains("1.15") && !Bukkit.getServer().getVersion().contains("1.14")) {
            System.out.println(ChatColor.RED + " Wersja " + Bukkit.getServer().getVersion() + " nie jest wspierana!");
            return;
        }
        this.saveDefaultSettings();
        DataManager dataManager = new DataManager(this, "bukkit.yml", "spigot.yml", "paper.yml");
        dataManager.loadDataFromConfig();
    }

    private void saveDefaultSettings() {
        this.saveResource("bukkit.yml", false);
        this.saveResource("spigot.yml", false);
        this.saveResource("paper.yml", false);
    }
}