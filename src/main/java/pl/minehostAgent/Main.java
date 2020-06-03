package pl.minehostAgent;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import pl.minehostAgent.data.DataLoader;

public final class Main extends JavaPlugin {

    @Override
    public void onLoad() {
        if (Bukkit.getServer().getVersion().contains("1.15") || Bukkit.getServer().getVersion().contains("1.14")) {
            DataLoader dataLoader = new DataLoader();
            dataLoader.load();

            super.onLoad();
        } else {
            System.out.println(ChatColor.RED + " Wersja " + Bukkit.getServer().getVersion() + " nie jest wspierana!");
        }
    }

    @Override
    public void onEnable() {
        super.onEnable();
    }
}