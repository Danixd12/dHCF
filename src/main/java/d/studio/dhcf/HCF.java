package d.studio.dhcf;

import d.studio.dhcf.dcommands.CommandHandler;
import d.studio.dhcf.dconfig.ConfigHandler;
import d.studio.dhcf.dlisteners.ListenerHandler;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public final class HCF extends JavaPlugin {

    Logger logger = getLogger();


    @Override
    public void onEnable() {

        logger.info(ChatColor.BLACK + "dHCF Plugin is enabled!");

        //commands
        new CommandHandler();
        //listeners
        new ListenerHandler(this);

        //new CommandHandler().getCommands();
        //new CommandHandler().findCommandByName("test");

        //config
        new ConfigHandler().loadConfig("config.yml", "data");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        logger.info("dHCF Plugin is disabled!");
    }

    private ConfigHandler loadConfig(){
        return loadConfig();
    }



}
