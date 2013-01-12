package net.minecraft.server.Plugins.Events.Player;

import net.minecraft.server.Plugins.Events.Event;
import net.minecraft.src.Block;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

/**
 * Fired when a player wants to place a {@link Block}
 * @author gravypod
 *
 */
public class BlockPlaceEvent extends Event {
	
	private EntityPlayer player;
	
	private ItemStack toPlace;
	
	private ChunkPosition location;
	
	private World world;
	
	/**
	 * Create a new {@link BlockPlaceEvent}
	 * @param world - {@link World} to place the block in
	 * @param player - {@link EntityPlayer} who wants to place the block
	 * @param toPlace - {@link ItemStack} they want to place
	 * @param location - {@link ChunkPosition} they want to place the {@link ItemStack} at
	 */
	public BlockPlaceEvent(World world, EntityPlayer player, ItemStack toPlace, ChunkPosition location) {
	
		this.player = player;
		this.toPlace = toPlace;
		this.location = location;
		this.world = world;
	}
	
	/**
	 * Location the {@link Block} will be placed at if the {@link Event} is not cancelled
	 * @return - {@link ChunkPosition} instance containing the X, Y, and Z coordinates
	 */
	public ChunkPosition getLocation() {
	
		return location;
	}
	
	/**
	 * The {@link EntityPlayer} who fired this event
	 * @return - The {@link EntityPlayer} instance 
	 */
	public EntityPlayer getPlayer() {
	
		return player;
	}
	
	/**
	 * The {@link ItemStack} that will be placed if this {@link Event} is not cancelled 
	 * @return - {@link ItemStack} instance
	 */
	public ItemStack getToPlace() {
	
		return toPlace;
	}
	
	/**
	 * The world the block will be placed in if the {@link Event} is not cancelled
	 * @return
	 */
	public World getWorld() {
	
		return world;
	}
	
}
