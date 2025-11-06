package com.lougagrou;

import org.bukkit.plugin.java.JavaPlugin;
import com.lougagrou.Commands; 
import com.lougagrou.menu.MainMenu;

public class Plugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Lougagrou plugin activé !");

        Commands executor = new Commands(this);
        this.getCommand("lgg").setExecutor(executor);
        getServer().getPluginManager().registerEvents(new MainMenu(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Lougagrou plugin désactivé !");
    }
}
