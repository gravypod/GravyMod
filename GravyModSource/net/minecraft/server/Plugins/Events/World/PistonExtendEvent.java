package net.minecraft.server.Plugins.Events.World;

import net.minecraft.server.Plugins.Events.Event;
import net.minecraft.src.BlockPistonBase;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.World;

public class PistonExtendEvent extends Event {
	
	private World world;
	
	private BlockPistonBase souceBlock;
	
	private ChunkCoordinates to;
	
	public PistonExtendEvent(World world, BlockPistonBase souceBlock, ChunkCoordinates to) {
	
		this.world = world;
		this.souceBlock = souceBlock;
		this.to = to;
		
	}
	
	/**
	 * Gets the piston base
	 * @return - {@link BlockPistonBase} instance
	 */
	public BlockPistonBase getSouceBlock() {
	
		return souceBlock;
	}
	
	/**
	 * Get where this block will be moving
	 * @return - {@link ChunkCoordinates} instance
	 */
	public ChunkCoordinates getTo() {
	
		return to;
	}
	
	/**
	 * Get the {@link World} this is occurring in
	 * @return - {@link World} instance
	 */
	public World getWorld() {
	
		return world;
	}
	
}
