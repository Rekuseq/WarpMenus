package me.rekuseq.warpmenusreku.Utilities;

import me.rekuseq.warpmenusreku.WarpMenusReku;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class WarpManager {
    private List<Warp> warplist = new ArrayList<>();
    private WarpMenusReku plugin;
    private ConfigurationSection section;

    public WarpManager(WarpMenusReku plugin) {
        this.plugin = plugin;
        this.section = plugin.configManager.getConfigurationSection();

        for (String str : section.getKeys(false)) {
            addWarp(new Warp(section.getString(str + ".name"),
                    section.getInt(str + ".slot-number"),
                    new ItemStack(Material.valueOf(section.getString(str + ".item").toUpperCase(Locale.ROOT))),
                    section.getString(str + ".display-name"),
                    section.getStringList(str + ".lore")));
        }

    }

    public void addWarp(Warp warp) {
        warplist.add(warp);
    }

    public Warp getWarp(String name) {
        for (Warp warp : warplist) {
            if (warp.getName() == name) {
                return warp;
            }
        }
        return null;
    }

    public List<Warp> getWarplist() {
        return warplist;
    }
}
