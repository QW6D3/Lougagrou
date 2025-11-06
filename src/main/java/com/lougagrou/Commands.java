package com.lougagrou;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.lougagrou.menu.MainMenu; // 👈 Import du menu principal

public class Commands implements CommandExecutor {

    private final Plugin plugin;

    public Commands(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // 1. Vérifie que l'expéditeur est un joueur
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cCette commande ne peut être exécutée que par un joueur.");
            return true;
        }

        Player player = (Player) sender;

        // 2. Si aucun argument n'est fourni, affiche l'aide
        if (args.length == 0) {
            sendHelpMessage(player);
            return true;
        }

        // 3. Gère les sous-commandes
        switch (args[0].toLowerCase()) {
            case "menu":
                MainMenu.open(player); // 👈 Ouvre le menu principal
                break;
            case "help":
                sendHelpMessage(player);
                break;
            default:
                player.sendMessage("§cCommande inconnue. Tape §6/lgg help §cpour voir l'aide.");
                break;
        }

        return true;
    }

    // Affiche le message d'aide
    private void sendHelpMessage(Player player) {
        player.sendMessage("§6=== §eLougagrou §6===");
        player.sendMessage("§e/lgg menu §7- Ouvrir le menu principal");
        player.sendMessage("§e/lgg help §7- Afficher cette aide");
        player.sendMessage("§6=================");
    }
}
