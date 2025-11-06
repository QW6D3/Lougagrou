package com.lougagrou.menu;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class MenuUtils {

    /**
     * Crée un item personnalisé avec un nom et un lore.
     * @param material Le matériau de l'item.
     * @param name Le nom de l'item (avec codes couleur).
     * @param lore Le lore de l'item (optionnel).
     * @return L'ItemStack personnalisé.
     */
    public static ItemStack createItem(Material material, String name, String... lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        if (lore != null && lore.length > 0) {
            meta.setLore(Arrays.asList(lore));
        }
        item.setItemMeta(meta);
        return item;
    }
    public static void addDecoration(Inventory menu) {
        for(int i = 9; i <18; i++){
            Material glassPannel = (i % 2 == 0) ? Material.ORANGE_STAINED_GLASS_PANE : Material.RED_STAINED_GLASS_PANE;
            menu.setItem(i, MenuUtils.createItem(glassPannel, " "));
        }
    }
}

