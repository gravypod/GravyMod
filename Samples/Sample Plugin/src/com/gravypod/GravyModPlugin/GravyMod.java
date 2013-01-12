package com.gravypod.GravyModPlugin;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.Plugins.Plugin;
import net.minecraft.server.Plugins.Events.Listener;
import net.minecraft.src.ServerCommandManager;


public class GravyMod extends Plugin {
	
	final List<String> lists = new ArrayList<String>();
	
	@Override
	public void onEnable(MinecraftServer server) {
		
		ServerCommandManager ch = (ServerCommandManager) server.getCommandManager();
		
		ch.registerCommand(new TestingCommand());
		
		ch.registerCommand(new FeedCommand());
		
		ch.registerCommand(new CraftingBenchCommand());
		
		Listener l = new PlayerListener();
		
		getAssistant().registerEvents(this, l);
		
	}

	@Override
    public void onDisable(MinecraftServer arg0) {
    
	    
    }
	
}
