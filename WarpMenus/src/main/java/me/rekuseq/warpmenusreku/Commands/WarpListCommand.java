package me.rekuseq.warpmenusreku.Commands;


import me.rekuseq.warpmenusreku.WarpMenusReku;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class WarpListCommand implements CommandExecutor {
    private final WarpMenusReku plugin;
    public WarpListCommand(WarpMenusReku plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(cmd.getName().equalsIgnoreCase("warplist")){
                if(args.length == 0){
                    if(p.hasPermission("warplist.warplistcommand") || p.isOp()){
                        plugin.warpsGui.openWarpsGui(p);
                    }
                }
            }
        }else{
            sender.sendMessage("");
        }
        return false;
    }
}
