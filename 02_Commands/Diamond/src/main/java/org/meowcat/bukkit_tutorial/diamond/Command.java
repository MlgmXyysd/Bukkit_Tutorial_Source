package org.meowcat.bukkit_tutorial.diamond;

import com.google.common.base.Charsets;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;
import java.util.UUID;

public class Command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length>=1) {
                if (player.hasPermission("tutorial.diamond.other")) {
                    Player given = Bukkit.getPlayer(getOfflineUUID(args[0]));
                    if (Objects.requireNonNull(given).isOnline()) {
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "give " + args[0] + " minecraft:diamond 1");
                    } else {
                        player.sendMessage("玩家不在线或不存在");
                    }
                } else {
                    player.sendMessage("你没有tutorial.diamond.other权限");
                }
            } else {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "give " + player.getDisplayName() + " minecraft:diamond 1");
            }
        } else {
            if (args.length>=1) {
                Player given = Bukkit.getPlayer(getOfflineUUID(args[0]));
                if (Bukkit.getOnlinePlayers().contains(given)) {
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "give " + args[0] + " minecraft:diamond 1");
                } else {
                    sender.sendMessage("玩家不在线或不存在");
                }
            } else {
                sender.sendMessage("不是一个玩家");
            }
        }
        return true;
    }

    private UUID getOfflineUUID(String playerName) {
        return UUID.nameUUIDFromBytes(("OfflinePlayer:" + playerName).getBytes(Charsets.UTF_8));
    }
}
