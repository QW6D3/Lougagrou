package com.lougagrou.menu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

public class GamelistMenu implements Listener {
    public static void open(Player player) {
        
        Inventory menu = Bukkit.createInventory(null, 54, "§6§lListe des parties");

        MenuUtils.addDecoration(menu);

        player.openInventory(menu);
    }
}
