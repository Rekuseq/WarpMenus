package me.rekuseq.warpmenusreku.Utilities;

import org.bukkit.ChatColor;

public enum Message {
    /* MESSAGES */
    /* SYSTEM */
    PREFIX( "&7[&WarpsMenu&7] &b => &f"),
    PLUGIN_ENABLED("&a[WarpsMenu] Plugin Enabled"),
    PLUGIN_DISABLED("&4[WarpsMenu] Plugin Disabled");


    String defaultMessage;

    Message(String defaultMessage){
        this.defaultMessage = defaultMessage;
    }

    public String getMessage(){
        return ChatColor.translateAlternateColorCodes('&', defaultMessage);
    }
}
