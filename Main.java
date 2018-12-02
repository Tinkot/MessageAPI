package me.Tinkot.MessageApi;

import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {

	public void onEnable() {
        this.getProxy().getPluginManager().registerCommand((Plugin)this, (Command)new CMD());
	}
}