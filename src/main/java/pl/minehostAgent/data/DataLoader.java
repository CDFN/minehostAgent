package pl.minehostAgent.data;

import org.bukkit.ChatColor;
import pl.minehostAgent.managers.ConfingManager;

import java.io.File;
import java.util.Map;

public class DataLoader {

    private static DataLoader instance;

    private File paperFile;
    private File bukkitFile;
    private File spigotFile;

    public DataLoader() {

        instance = this;

    }

    public static DataLoader getInstance() {
        return instance;
    }

    public void load() {

        this.paperFile = new File("paper.yml");
        this.bukkitFile = new File("bukkit.yml");
        this.spigotFile = new File("spigot.yml");

        Map<String, Object> spigotMap = ConfingManager.getSpigotMap();
        Map<String, Object> bukkitMap = ConfingManager.getBukkitMap();
        Map<String, Object> paperMap = ConfingManager.getPaperMap();

        //Bukkit settings
        bukkitMap.put("spawn-limits.monsters", 50);
        bukkitMap.put("spawn-limits.animals", 8);
        bukkitMap.put("spawn-limits.water-animals", 3);
        bukkitMap.put("spawn-limits.ambient", 1);
        bukkitMap.put("chunk-gc.period-in-ticks", 400);
        bukkitMap.put("ticks-per.monster-spawns", 4);
        bukkitMap.put("ticks-per.autosave", 6000);

        //Spigot settings
        spigotMap.put("settings.save-user-cache-on-stop-only", true);
        spigotMap.put("world-settings.default.max-tick-time.tile", 1000);
        spigotMap.put("world-settings.default.max-tick-time.entity", 1000);
        spigotMap.put("world-settings.default.mob-spawn-range", 6);
        spigotMap.put("world-settings.default.entity-activation-range.animals", 16);
        spigotMap.put("world-settings.default.entity-activation-range.monsters", 24);
        spigotMap.put("world-settings.default.entity-activation-range.raiders", 48);
        spigotMap.put("world-settings.default.entity-activation-range.misc", 8);
        spigotMap.put("world-settings.default.entity-activation-range.water", 1);
        spigotMap.put("world-settings.default.entity-activation-range.tick-inactive-villagers", false);
        spigotMap.put("world-settings.default.merge-radius.exp", 6.0);
        spigotMap.put("world-settings.default.merge-radius.item", 4.0);
        spigotMap.put("world-settings.default.item-despawn-rate", 4000);
        spigotMap.put("world-settings.default.arrow-despawn-rate", 300);

        //Paper settings
        paperMap.put("world-settings.default.max-auto-save-chunks-per-tick", 6);
        paperMap.put("world-settings.default.optimize-explosions", false);
        paperMap.put("world-settings.default.mob-spawner-tick-rate", 2);
        paperMap.put("world-settings.default.game-mechanics.disable-chest-cat-detection", true);
        paperMap.put("world-settings.default.container-update-tick-rate", 3);
        paperMap.put("world-settings.default.max-entity-collisions", 2);
        paperMap.put("world-settings.default.grass-spread-tick-rate", 4);
        paperMap.put("world-settings.default.despawn-ranges.soft", 28);
        paperMap.put("world-settings.default.despawn-ranges.hard", 96);
        paperMap.put("world-settings.default.hopper.disable-move-event", true);
        paperMap.put("world-settings.default.non-player-arrow-despawn-rate", 60);
        paperMap.put("world-settings.default.creative-arrow-despawn-rate", 60);
        paperMap.put("world-settings.default.prevent-moving-into-unloaded-chunks", true);
        paperMap.put("world-settings.default.use-faster-eigencraft-redstone", true);
        paperMap.put("world-settings.default.armor-stands-tick", false);
        paperMap.put("world-settings.default.per-player-mob-spawns", true);
        paperMap.put("world-settings.default.alt-item-despawn-rate.enabled", true);
        paperMap.put("world-settings.default.alt-item-despawn-rate.items.COBBLESTONE", 400);
        paperMap.put("world-settings.default.alt-item-despawn-rate.items.NETHERRACK", 400);
        paperMap.put("world-settings.default.alt-item-despawn-rate.items.DIRT", 400);
        paperMap.put("world-settings.default.alt-item-despawn-rate.items.STONE", 400);
        paperMap.put("world-settings.default.anti-xray.enabled", true);

        final DataHelper spigotDataHelper = new DataHelper(DataLoader.getInstance().getSpigotFile());
        spigotMap.forEach(spigotDataHelper::set);

        final DataHelper bukkitDataHelper = new DataHelper(DataLoader.getInstance().getBukkitFile());
        bukkitMap.forEach(bukkitDataHelper::set);

        final DataHelper paperDataHelper = new DataHelper(DataLoader.getInstance().getPaperFile());
        paperMap.forEach(paperDataHelper::set);

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


    public File getBukkitFile() {
        return bukkitFile;
    }

    public File getSpigotFile() {
        return spigotFile;
    }

    public File getPaperFile() {
        return paperFile;
    }
}