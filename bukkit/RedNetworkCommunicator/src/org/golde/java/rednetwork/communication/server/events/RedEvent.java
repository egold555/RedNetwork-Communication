package org.golde.java.rednetwork.communication.server.events;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class RedEvent extends Event {

	private static final HandlerList handlers = new HandlerList();

	public final HandlerList getHandlers() {
	    return handlers;
	}

	public static final HandlerList getHandlerList() {
	    return handlers;
	}
	
	public final void call() {
		Bukkit.getPluginManager().callEvent(this);
	}
	
}
