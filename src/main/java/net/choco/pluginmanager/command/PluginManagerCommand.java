package net.choco.pluginmanager.command;

import me.mattstudios.mf.annotations.Command;
import me.mattstudios.mf.annotations.Default;
import me.mattstudios.mf.annotations.Permission;
import me.mattstudios.mf.annotations.SubCommand;
import me.mattstudios.mf.base.CommandBase;
import net.choco.pluginmanager.utility.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

@Command("pm")
public class PluginManagerCommand extends CommandBase {

    @Default
    public void defaultCommand(CommandSender sender) {
        sender.sendMessage(ChatUtils.color("&a/pm enable <plugin>"));
        sender.sendMessage(ChatUtils.color("&a/pm disable <plugin>"));
    }

    @SubCommand("enable")
    @Permission("pluginmanager.enable")
    public void enableCommand(CommandSender sender, String pluginName) {
        Plugin plugin = Bukkit.getPluginManager().getPlugin(pluginName);
        if (plugin == null) {
            sender.sendMessage(ChatUtils.color("&cplugin not found!"));
            return;
        }
        sender.sendMessage(ChatUtils.color("&aSuccessfully enabled " + plugin));
        Bukkit.getPluginManager().enablePlugin(plugin);
    }

    @SubCommand("disable")
    @Permission("pluginmanager.disable")
    public void disableCommand(CommandSender sender, String pluginName) {
        Plugin plugin = Bukkit.getPluginManager().getPlugin(pluginName);
        if (plugin == null) {
            sender.sendMessage(ChatUtils.color("&cplugin not found!"));
            return;
        }
        sender.sendMessage(ChatUtils.color("&aSuccessfully disabled " + plugin));
        Bukkit.getPluginManager().disablePlugin(plugin);
    }
}
