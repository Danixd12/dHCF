package d.studio.dhcf.dutils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Chat {

    public void sendMessage(Player player, String message) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }



}
