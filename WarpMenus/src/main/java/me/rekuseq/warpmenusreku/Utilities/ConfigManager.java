package me.rekuseq.warpmenusreku.Utilities;


import me.rekuseq.warpmenusreku.WarpMenusReku;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.*;
import java.util.List;

public class ConfigManager {

    private WarpMenusReku plugin;
    private FileConfiguration config;
    private ConfigurationSection section;
    private YamlConfiguration yaml;
    private final File file = new File("plugins/WarpMenusReku/config.yml");

    public ConfigManager(WarpMenusReku plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    public void loadConfig() {
        generateConfig();

        yaml = YamlConfiguration.loadConfiguration(file);
        if (yaml.isConfigurationSection("warp-list")) {
            section = yaml.getConfigurationSection("warp-list");
        } else {
            section = yaml.createSection("warp-list");
        }
    }

    public void reloadConfig() {
        generateConfig();
        plugin.reloadConfig();
    }

    public void generateConfig() {
        File file = new File(plugin.getDataFolder() + File.separator + "config.yml");
        File folderFile = new File(plugin.getDataFolder().toString());
        if (!file.exists()) {
            if (!folderFile.isDirectory()) folderFile.mkdir();
            try (OutputStream outputStream = new FileOutputStream(file.toPath().toString())) {
                InputStream is = plugin.getResource("config.yml");
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }
                is.close();
            } catch (IOException e) {
                e.printStackTrace();

            }

        }
    }

    public String getString(String path){
        return config.getString(path);
    }

    public List<String> getStringList(String path){
        return config.getStringList(path);
    }

    public int getInt(String path){
        return config.getInt(path);
    }

    public List<Integer> getIntList(String path){
        return config.getIntegerList(path);
    }
    public boolean getBoolean(String path){
        return config.getBoolean(path);
    }
    public ConfigurationSection getConfigurationSection(){
        return section;
    }

}
