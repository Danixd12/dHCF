package d.studio.dhcf.dlisteners.Listeners;

import d.studio.dhcf.dconfig.ConfigHandler;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;

public class PlayerJoinListener implements Listener {

    ConfigHandler configHandler = new ConfigHandler();


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) throws IOException, InvalidConfigurationException {
        Player player = event.getPlayer();


        if(player.hasPlayedBefore()) {

            configHandler.getConfig("users.yml", "data");

        }
    }

}
