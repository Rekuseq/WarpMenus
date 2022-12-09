package me.rekuseq.warpmenusreku;

import me.rekuseq.warpmenusreku.Commands.WarpListCommand;
import me.rekuseq.warpmenusreku.Listeners.InventoryClickListener;
import me.rekuseq.warpmenusreku.Utilities.ConfigManager;
import me.rekuseq.warpmenusreku.Utilities.Message;
import me.rekuseq.warpmenusreku.Utilities.WarpManager;
import me.rekuseq.warpmenusreku.Utilities.WarpsGui;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class WarpMenusReku extends JavaPlugin {
    public final WarpListCommand warpListCommand;
    public final ConfigManager configManager;
    public final WarpsGui warpsGui;
    private final InventoryClickListener inventoryClickListener;
    public final WarpManager warpManager;

    public WarpMenusReku() {
        this.configManager = new ConfigManager(this);
        configManager.loadConfig();
        this.warpListCommand = new WarpListCommand(this);
        this.warpManager = new WarpManager(this);
        this.warpsGui = new WarpsGui(this);
        this.inventoryClickListener = new InventoryClickListener(this);
    }


    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(Message.PLUGIN_ENABLED.getMessage());
        getCommand("warplist").setExecutor(warpListCommand);
        getServer().getPluginManager().registerEvents(inventoryClickListener, this);
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(Message.PLUGIN_DISABLED.getMessage());
    }
}
