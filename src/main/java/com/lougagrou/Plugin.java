package com.lougagrou;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

/*
 * lougagrou java plugin
 */
public class Plugin extends JavaPlugin
{
  private static final Logger LOGGER=Logger.getLogger("lougagrou");

  public void onEnable()
  {
    LOGGER.info("lougagrou enabled");
  }

  public void onDisable()
  {
    LOGGER.info("lougagrou disabled");
  }
}
