package org.golde.java.rednetwork.communication.client;

import java.util.Timer;
import java.util.TimerTask;

import org.golde.java.rednetwork.communication.common.CommonConstants;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ClientConnectedToServerEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = "rednetwork", version = "1.0", clientSideOnly = true)
public class RedNetworkMod {

	private SimpleNetworkWrapper network;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		network = NetworkRegistry.INSTANCE.newSimpleChannel(CommonConstants.CHANNEL_NAME);
		network.registerMessage(CommunicationMessage.Handler.class, CommunicationMessage.class, 0, Side.CLIENT);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public void join(ClientConnectedToServerEvent event) {
		
		Timer timer = new Timer();
		TimerTask tt = new TimerTask() {

			@Override
			public void run() {
				network.sendToServer(new CommunicationMessage("Using"));
			}
		};
		timer.schedule(tt, 3000);

	}
}
