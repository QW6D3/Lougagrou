package com.lougagrou;

import org.bukkit.plugin.java.JavaPlugin;

import com.lougagrou.commands.StartGameCommand;
import com.lougagrou.events.GameListener;

public class LoupGagrouPlugin extends JavaPlugin {
  @Override
  public void onEnable() {
    getLogger().info("LoupGarou Plugin Activé !");

    // Enregistrement des commandes et évenements
    getCommand("startgame").setExecutor(new StartGameCommand(this));
    getServer().getPluginManager().registerEvents(new GameListener(), this);
  }

  @Override
    public void onDisable() {
        getLogger().info("LoupGarou Plugin Désactivé !");
    }
}
