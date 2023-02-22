package d.studio.dhcf.dconfig;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConfigHandler {

    File file;
    FileConfiguration config = Bukkit.getPluginManager().getPlugin("dHCF").getConfig();
    Map<String, String> files = new HashMap<>();


    public ConfigHandler() {
        loadConfig("factions.yml", "data");
        loadConfig("users.yml", "data");
    }

    /**
     * Loads the config
     */
    public void loadConfig(String name, String path) {
        file = new File(Bukkit.getPluginManager().getPlugin("dHCF").getDataFolder()+"/"+path, name);
        File configfile = new File(Bukkit.getPluginManager().getPlugin("dHCF").getDataFolder(), "config.yml"); // config file

        if (!file.exists()) {
            file.getParentFile().mkdirs();
            Bukkit.getPluginManager().getPlugin("dHCF").saveResource(path+"/"+name, false);
        }

        if (!configfile.exists()) {
            file.getParentFile().mkdirs();
            Bukkit.getPluginManager().getPlugin("dHCF").saveResource("config.yml", false);
            System.out.println("[dHCF] Config file created!");
        }

        config = new YamlConfiguration();

        try {
                config.load(file);
                config.load(configfile);

                System.out.println("[dHCF] Files loaded!");
        } catch (IOException | InvalidConfigurationException e) {
            System.out.println("[dHCF] Failed to load files!");
            e.printStackTrace();
        }

    }

    //TODO: register config using a map
    public void registerConfig(String name, FileConfiguration fileConfiguration){
        files.put(name, fileConfiguration.toString());
    }

    /**
     * get config from specified file
     * @return config
     */
    public FileConfiguration getConfig(String name, String path) throws IOException {
        FileConfiguration data = YamlConfiguration.loadConfiguration(new File(Bukkit.getPluginManager().getPlugin("dHCF").getDataFolder()+"/"+path, name));
        data.save(new File(Bukkit.getPluginManager().getPlugin("dHCF").getDataFolder()+"/"+path, name));
        return data;
    }

}


/*
 public void loadConfig(String name, FileConfiguration fileConfiguration){
        File file = new File(Bukkit.getPluginManager().getPlugin("dHCF").getDataFolder(), "config.yml");
        File factionsfile = new File(Bukkit.getPluginManager().getPlugin("dHCF").getDataFolder() + "/data", "factions.yml");
        File englishlangfile = new File(Bukkit.getPluginManager().getPlugin("dHCF").getDataFolder() + "/lang", "en_us.yml");


        config = new YamlConfiguration();
        if(file.exists() && factionsfile.exists()){
            try {
                config.load(file);
                config.load(factionsfile);
            } catch (IOException | InvalidConfigurationException e) {
                e.printStackTrace();
            }
        } else if(!factionsfile.exists()){
            factionsfile.getParentFile().mkdir();

            Bukkit.getPluginManager().getPlugin("dHCF").saveResource("data/factions.yml", false);
         } else if(!file.exists()){
            file.getParentFile().mkdirs();
            Bukkit.getPluginManager().getPlugin("dHCF").saveResource("config.yml", false);
        } else if(!englishlangfile.exists()){
            englishlangfile.getParentFile().mkdirs();
            Bukkit.getPluginManager().getPlugin("dHCF").saveResource("lang/en_us.yml", false);
        }
    }
 */