package me.rekuseq.warpmenusreku.Listeners;

import me.rekuseq.warpmenusreku.Utilities.Warp;
import me.rekuseq.warpmenusreku.WarpMenusReku;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClickListener implements Listener {

    private final WarpMenusReku plugin;

    public InventoryClickListener(WarpMenusReku plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getWhoClicked() instanceof Player) {
            Player p = (Player) e.getWhoClicked();
            if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', plugin.configManager.getString("menu-title")))) {
                if (e.getCurrentItem() == null) {
                    return;
                }
                ItemStack item = e.getCurrentItem();
                e.setCancelled(true);
                if(item.hasItemMeta()){
                    for(Warp warp : plugin.warpManager.getWarplist()){
                        if(item.getItemMeta().getDisplayName().equals(warp.getDisplay_name())){
                            p.performCommand("warp " + warp.getName());
                        }
                    }
                }else{
                    return;
                }
            }
        }

    }
}
