package d.studio.dhcf.dlisteners;

import d.studio.dhcf.dcommands.Commands.CreateFaction;
import d.studio.dhcf.dlisteners.Listeners.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

public class ListenerHandler {

    private final HashMap<String, Listener> commands = new HashMap<>();

    /**
     * Register all Listeners here
     */
    public ListenerHandler(Plugin plugin) {

        registerListener("test", new PlayerJoinListener(), plugin);

    }

    /**
     * Register a listener
     * @param name
     * @param command
     */
    public void registerListener(String name, Listener listener, Plugin plugin) {
        commands.put(name, listener);
        Bukkit.getPluginManager().registerEvents(listener, plugin);
    }

    /**
     * Get all listeners
     */
    public void getListeners() {
        System.out.println("Registered listeners: ");
        commands.forEach((key, value) -> System.out.println(key.toString()));
    }

    /**
     * Find a listener by name
     * @param name
     */
    public void findListenerByName(String name) {
        commands.forEach((key, value) -> {
            if (key.equalsIgnoreCase(name)) {
                System.out.println(key);
            } else {
                System.out.println("Command not found!");
            }
        });
    }

}
