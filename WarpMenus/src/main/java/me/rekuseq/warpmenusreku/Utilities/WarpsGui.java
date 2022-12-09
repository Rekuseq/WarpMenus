package me.rekuseq.warpmenusreku.Utilities;

import me.rekuseq.warpmenusreku.WarpMenusReku;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Locale;

public class WarpsGui {

    private final WarpMenusReku plugin;

    public WarpsGui(WarpMenusReku plugin) {
        this.plugin = plugin;
    }

    public void openWarpsGui(Player p) {
        Inventory inventory = plugin.getServer().createInventory(
                p, plugin.configManager.getInt("slots"),
                ChatColor.translateAlternateColorCodes('&', plugin.configManager.getString("menu-title")));
        if(plugin.configManager.getBoolean("frame.enable")){
            for(int i : plugin.configManager.getIntList("frame.slot-numbers")){
                ItemStack frame = new ItemStack(Material.valueOf(plugin.configManager.getString("frame.item").toUpperCase(Locale.ROOT)));
                ItemMeta frame_meta = frame.getItemMeta();
                frame_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', (plugin.configManager.getString("frame.display-name"))));
                frame.setItemMeta(frame_meta);

                inventory.setItem(i, frame);
            }
        }
        for (Warp warp : plugin.warpManager.getWarplist()) {
            ItemStack item = warp.getItem();
            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setDisplayName(warp.getDisplay_name());
            itemMeta.setLore(warp.getLore());
            item.setItemMeta(itemMeta);
            inventory.setItem(warp.getSlot_number(), item);
        }


        p.openInventory(inventory);
    }
}
