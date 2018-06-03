package org.golde.bukkit.redexample;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.golde.java.rednetwork.communication.server.events.RedClientFoundEvent;

public class Main extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void onRedClientFound(RedClientFoundEvent e) {
		e.getPlayer().sendMessage("Thank you for using the RedClient <3");
		Bukkit.getLogger().info(e.getPlayer().getName() + " is using the RedClient!");
	}

}
