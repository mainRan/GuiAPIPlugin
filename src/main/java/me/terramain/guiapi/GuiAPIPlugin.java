package me.terramain.guiapi;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class GuiAPIPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new GUIManager(),this);
    }

    @Override
    public void onDisable() {

    }
}
