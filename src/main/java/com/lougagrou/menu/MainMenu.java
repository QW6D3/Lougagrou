package com.lougagrou.menu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MainMenu implements Listener {

    /**
     * Ouvre le menu principal pour un joueur.
     * @param player Le joueur à qui ouvrir le menu.
     */
    public static void open(Player player) {
        Inventory menu = Bukkit.createInventory(null, 36, "§6§lLougagrou Menu");

        // Bordure supérieure (slots 0-8) - alternance orange/rouge
        for (int i = 0; i < 9; i++) {
            Material glassMaterial = (i % 2 == 0) ? Material.ORANGE_STAINED_GLASS_PANE : Material.RED_STAINED_GLASS_PANE;
            menu.setItem(i, MenuUtils.createItem(glassMaterial, " "));
        }

        // Bordure inférieure (slots 27-35) - alternance orange/rouge
        for (int i = 27; i < 36; i++) {
            Material glassMaterial = (i % 2 == 0) ? Material.ORANGE_STAINED_GLASS_PANE : Material.RED_STAINED_GLASS_PANE;
            menu.setItem(i, MenuUtils.createItem(glassMaterial, " "));
        }

        // Côtés gauche et droit
        menu.setItem(9, MenuUtils.createItem(Material.RED_STAINED_GLASS_PANE, " "));
        menu.setItem(17, MenuUtils.createItem(Material.RED_STAINED_GLASS_PANE, " "));
        menu.setItem(18, MenuUtils.createItem(Material.ORANGE_STAINED_GLASS_PANE, " "));
        menu.setItem(26, MenuUtils.createItem(Material.ORANGE_STAINED_GLASS_PANE, " "));

        // Items principaux
        menu.setItem(12, MenuUtils.createItem(Material.CHEST, "§b§lCréer une partie",
            "§7Configurer et lancer une nouvelle partie",
            "§8(Mode Loup-Garou, durée, joueurs...)"));

        menu.setItem(14, MenuUtils.createItem(Material.COMPASS, "§a§lRechercher une partie",

        "§7Trouver et rejoindre une partie existante"));

        menu.setItem(22, MenuUtils.createItem(Material.BARRIER, "§c§lFermer le menu"));

        player.openInventory(menu);
    }

    /**
     * Gère les clics dans le menu principal.
     */
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        // Vérifie que le clic est dans ce menu
        if (!event.getView().getTitle().equals("§6§lLougagrou Menu")) {
            return;
        }

        // Bloque les interactions par défaut
        event.setCancelled(true);

        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();

        // Vérifie que l'item cliqué existe et a des métadonnées
        if (clickedItem == null || !clickedItem.hasItemMeta()) {
            return;
        }

        // Gestion des clics
        switch (clickedItem.getType()) {
            case CHEST:
                if (clickedItem.getItemMeta().getDisplayName().equals("§b§lCréer une partie")) {
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1.0f, 1.0f);
                    player.sendMessage("§a[Lougagrou] §7Ouverture du menu de création...");
                    // TODO: CreateMenu.open(player);
                    break;
                }
            case COMPASS:
                if (clickedItem.getItemMeta().getDisplayName().equals("§a§lRechercher une partie")) {
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1.0f, 1.0f);
                    player.sendMessage("§a[Lougagrou] §7Recherche des parties en cours...");
                    GamelistMenu.open(player);
                    break;
                }
            case BARRIER:
                if (clickedItem.getItemMeta().getDisplayName().equals("§c§lFermer le menu")) {
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE, 0.5f, 1.0f);
                    player.closeInventory();
                    break;
                }
        }
    }
}
