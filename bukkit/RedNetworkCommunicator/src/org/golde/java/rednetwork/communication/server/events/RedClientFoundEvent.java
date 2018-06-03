package org.golde.java.rednetwork.communication.server.events;

import org.bukkit.entity.Player;

public class RedClientFoundEvent extends RedEvent {

	private final Player player;
	
	public RedClientFoundEvent(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return player;
	}
	
}
