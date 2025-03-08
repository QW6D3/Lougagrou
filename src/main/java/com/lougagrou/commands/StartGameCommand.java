package com.lougagrou.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.lougagrou.LoupGagrouPlugin;

public class StartGameCommand implements CommandExecutor {
    private final LoupGagrouPlugin plugin;

    public StartGameCommand(LoupGagrouPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            sender.sendMessage("La partie commence !");
        }
        return true;
    }
}