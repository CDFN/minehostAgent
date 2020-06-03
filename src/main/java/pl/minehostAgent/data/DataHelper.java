package pl.minehostAgent.data;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class DataHelper {

    private File file;
    private FileConfiguration fileConfiguration;

    public DataHelper(File file) {
        this.file = file;

        this.fileConfiguration = YamlConfiguration.loadConfiguration(file);
    }

    public Object get(String path) {
        return this.fileConfiguration.get(path);
    }

    public Set<String> getKeys() {
        return this.fileConfiguration.getKeys(false);
    }

    public void set(String path, Object object) {
        this.fileConfiguration.set(path, object);

        try { this.save(); }catch (IOException ex) { ex.printStackTrace(); }
    }

    private void save() throws IOException {
        this.fileConfiguration.save(this.file);
    }
}