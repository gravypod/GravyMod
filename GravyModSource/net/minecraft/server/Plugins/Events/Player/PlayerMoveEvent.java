package net.minecraft.server.Plugins.Events.Player;

import net.minecraft.server.Plugins.Events.Event;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.World;

/**
 * Fired when a {@link EntityPlayer} moves
 * @author gravypod
 *
 */
public class PlayerMoveEvent extends Event {
	
	private ChunkPosition from;
	
	private ChunkPosition to;
	
	private EntityPlayer player;
	
	private World world;
	
	/**
	 * Create a {@link PlayerMoveEvent}
	 * @param entityPlayer - {@link EntityPlayer} who moved
	 * @param world - {@link World} they are in 
	 * @param from - {@link ChunkPosition} they came from
	 * @param to - {@link ChunkPosition} they are going to
	 */
	public PlayerMoveEvent(EntityPlayer entityPlayer, World world, ChunkPosition from, ChunkPosition to) {
	
		this.player = entityPlayer;
		this.world = world;
		this.from = from;
		this.to = to;
	}
	
	/**
	 * Get where the {@link EntityPlayer} is coming from
	 * @return - {@link ChunkPosition} the {@link EntityPlayer} came from
	 */
	public ChunkPosition getFrom() {
	
		return from;
	}
	
	/**
	 * Get the {@link EntityPlayer} who is moving
	 * @return - {@link EntityPlayer} who wants to move
	 */
	public EntityPlayer getPlayer() {
	
		return player;
	}
	
	/**
	 * Get the {@link ChunkPosition} the {@link EntityPlayer} is going to
	 * @return - {@link ChunkPosition} instance of where the player wants to go to
	 */
	public ChunkPosition getTo() {
	
		return to;
	}
	
	/**
	 * The {@link World} the {@link EntityPlayer} is in
	 * @return - {@link World} instance
	 */
	public World getWorld() {
	
		return world;
	}
	
}
