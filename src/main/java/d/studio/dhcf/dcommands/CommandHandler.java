package d.studio.dhcf.dcommands;

import d.studio.dhcf.dcommands.Commands.CreateFaction;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;

import java.util.HashMap;

public class CommandHandler {

    ICreateDaCommand commands = new ICreateDaCommand();

    /**
     * Register all commands here
     */
    public CommandHandler() {

        commands.registerCommand("createFaction", new CreateFaction());

    }



}
