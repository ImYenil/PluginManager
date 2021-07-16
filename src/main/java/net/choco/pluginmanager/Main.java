package net.choco.pluginmanager;

import me.mattstudios.mf.base.CommandManager;
import net.choco.pluginmanager.command.PluginManagerCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    private CommandManager commandManager;

    public void onEnable() {
        instance = this;
        commandManager = new CommandManager(this);
        commandManager.register(new PluginManagerCommand());
    }

    public static Main getInstance() {
        return instance;
    }
}
