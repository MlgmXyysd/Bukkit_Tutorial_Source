package org.meowcat.bukkit;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (sender instanceof Player) {
            sender.sendMessage("你成功执行了这个指令！");
            return true;
        } else {
            sender.sendMessage("你必须是一个玩家才能执行这个指令！");
            return false;
        }
    }
}
