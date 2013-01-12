package com.gravypod.GravyModPlugin;

import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.Plugins.Events.EventHandler;
import net.minecraft.server.Plugins.Events.EventPriority;
import net.minecraft.server.Plugins.Events.Listener;
import net.minecraft.server.Plugins.Events.Player.BlockBreakEvent;
import net.minecraft.server.Plugins.Events.Player.BlockPlaceEvent;
import net.minecraft.server.Plugins.Events.Player.FoodEatenEvent;
import net.minecraft.server.Plugins.Events.Player.ItemUseEvent;
import net.minecraft.server.Plugins.Events.World.BlockFallEvent;
import net.minecraft.server.Plugins.Events.World.ExplosionEvent;
import net.minecraft.server.Plugins.Events.World.FireSpreadEvent;
import net.minecraft.server.Plugins.Events.World.PistonPullBlockEvent;
import net.minecraft.src.Block;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.Item;

public class PlayerListener implements Listener {
	
	HashMap<String, Integer> moves = new HashMap<String, Integer>();
	
	/*
	 * @EventHandler public void playeDamageEvent(PlayerDamageEvent event) {
	 * 
	 * event.getDamageSource().getSourceOfDamage().mountEntity(event.getEntity())
	 * ;
	 * 
	 * MinecraftServer.logger.log(Level.INFO, "awdawfawf");
	 * 
	 * }
	 */
	
	@EventHandler
	public void playerEat(FoodEatenEvent event) {
	
		MinecraftServer.getServer().logInfo(event.getEntityPlayer().username + " has eaten " + event.getItemStack().getItemName());
		
		if (event.getItemStack().getItem() == Item.beefCooked) {
			
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler(priority = EventPriority.HIGH)
	public void blockBreakEvent(BlockBreakEvent event) {
	
		int blockID = event.getBlock().blockID;
		MinecraftServer.getServer().logInfo(blockID + "");
		
		if (blockID == 2) {
			
			event.setCancelled(true);
			
		}
		
		event.getPlayer().sendChatToPlayer("You have broken " + event.getBlock().getBlockName());
		
		MinecraftServer.logger.log(Level.SEVERE, event.getPlayer().username + " has broken " + event.getBlock().getBlockName());
		
	}
	
	@EventHandler
	public void explosionEvent(ExplosionEvent event) {
	
		Iterator<Block> blocks;
		Block block = null;
		for (blocks = event.getBlocks().iterator(); blocks.hasNext(); block = blocks.next()) {
			if (block == Block.blockDiamond) {
				blocks.remove();
			}
		}
		
	}
	
	@EventHandler()
	public void playerRightClick(ItemUseEvent event) {
	
		event.getPlayer().sendChatToPlayer(event.getItemStack().getItemName());
		
	}
	
	@EventHandler
	public void blockPlaceEvent(BlockPlaceEvent event) {
	
		ChunkPosition pos = event.getLocation();
		String itemName = event.getToPlace().getItemName();
		event.getPlayer().sendChatToPlayer("Placed: " + itemName + "; x: " + pos.x + "; y: " + pos.y + "; z: " + pos.z);
		if (itemName.contains("diamond")) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onFallEvent(BlockFallEvent event) {
	
		event.setCancelled(true);
		
	}
	
	@EventHandler
	public void fireSpreadEvent(FireSpreadEvent event) {
	
		event.getWorld().getPlayerEntityByName("gravypod").sendChatToPlayer(event.getSpreadToBlock().toString());
		event.setCancelled(true);
		
	}
	
	@EventHandler
	public void pistonPull(PistonPullBlockEvent event) {
	
		/*
		 * 
		 * Piston pull doesnt let to stop it, it also fires twice
		 * BlockPistonExtention.java:208
		 */
		event.getWorld().getPlayerEntityByName("gravypod").sendChatToPlayer("Moved: " + event.getBlockPulled().toString());
		if (event.getBlockPulled().getBlockName().contains("d"))
			event.setCancelled(true);
		
	}
	
}
