package d.studio.dhcf.dcommands;

import d.studio.dhcf.dcommands.Commands.CreateFaction;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;

import java.util.HashMap;

public class CommandHandler {

    private final HashMap<String, CommandExecutor> commands = new HashMap<>();

    /**
     * Register all commands here
     */
    public CommandHandler() {

        registerCommand("test", new CreateFaction());

    }

    /**
     * Register a command
     * @param name
     * @param command
     */
    public void registerCommand(String name, CommandExecutor command) {
        commands.put(name, command);
        Bukkit.getPluginCommand(name).setExecutor(command);
    }

    /**
     * Get all commands
     */
    public void getCommands() {
        System.out.println("Registered commands: ");
        commands.forEach((key, value) -> System.out.println(key.toString()));
    }

    /**
     * Find a command by name
     * @param name
     */
    public void findCommandByName(String name) {
        commands.forEach((key, value) -> {
            if (key.equalsIgnoreCase(name)) {
                System.out.println(key);
            } else {
                System.out.println("Command not found!");
            }
        });
    }

}
