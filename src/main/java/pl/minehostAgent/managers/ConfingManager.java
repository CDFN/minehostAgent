package pl.minehostAgent.managers;

import com.google.common.collect.Maps;

import java.util.Map;

public class ConfingManager {

    private static final Map<String, Object> spigotMap = Maps.newConcurrentMap();

    public static Map<String, Object> getSpigotMap() {
        return spigotMap;
    }

    private static final Map<String, Object> bukkitMap = Maps.newConcurrentMap();

    public static Map<String, Object> getBukkitMap() {
        return bukkitMap;
    }

    private static final Map<String, Object> paperMap = Maps.newConcurrentMap();

    public static Map<String, Object> getPaperMap() {
        return paperMap;
    }
}