package com.leaf48.crasher;

import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandSendEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Crasher extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info(Util.color("&d&lPlugin has been enabled"));
        this.getCommand("crash");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info(Util.color("&d&lPlugin has been disabled"));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(sender instanceof Player){
            Player player = (Player) sender;

            getLogger().info(Util.color("&cコマンドが実行されました"));

            if(args.length != 0){
                getLogger().info("引数があります");
                getLogger().info(args[0]);
                getServer().getPlayer(args[0]);
                Player target = getServer().getPlayer(args[0]);
                target.spawnParticle(Particle.LAVA, target.getLocation(), 3000);
                sender.sendMessage("address: " + target.getAddress().getHostName());
            }else{
                player.sendMessage(Util.color("&c&l引数を指定してください！"));
            }
        }

        return true;
    }
}
