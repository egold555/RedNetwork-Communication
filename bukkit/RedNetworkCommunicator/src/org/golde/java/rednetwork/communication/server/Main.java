package org.golde.java.rednetwork.communication.server;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.golde.java.rednetwork.communication.common.CommonConstants;
import org.golde.java.rednetwork.communication.server.events.RedClientFoundEvent;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

public class Main extends JavaPlugin implements PluginMessageListener {

	@Override
	public void onEnable() {
		this.getServer().getMessenger().registerOutgoingPluginChannel(this, CommonConstants.CHANNEL_NAME);
		this.getServer().getMessenger().registerIncomingPluginChannel(this, CommonConstants.CHANNEL_NAME, this);
	}
	
	@Override
	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
		ByteArrayDataInput in = ByteStreams.newDataInput(message);
		
		if(in != null) {
			if(channel.equals(CommonConstants.CHANNEL_NAME)) {
				String sub = in.readUTF();
				if(sub.equals("Using")) {
					new RedClientFoundEvent(player).call();
				} 
				else {
					//To implement later if needed
					//new RedClientMessageEvent(player, sub).call();
				}
			}
		}
	}
	
}
