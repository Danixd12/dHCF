package d.studio.dhcf.dcommands.Commands;

import d.studio.dhcf.dutils.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateFaction implements CommandExecutor {
    /**
     * Executes the given command, returning its success
     *
     * @param sender  Source of the command
     * @param command Command which was executed
     * @param label   Alias of the command which was used
     * @param args    Passed command arguments
     * @return true if a valid command, otherwise false
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

       Chat chat = new Chat();

        //make a command to send hello to player
        Player player = (Player) sender;
        chat.sendMessage(player, "&aHello!");

        return false;
    }
}
