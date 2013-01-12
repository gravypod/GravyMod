package net.minecraft.server.Plugins.Events.World;

import net.minecraft.server.Plugins.Events.Event;
import net.minecraft.src.BlockSand;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.World;

/**
 * Called when a block wants to fall
 * 
 * @author gravypod
 *
 */
public class BlockFallEvent extends Event {
	
	private World world;
	
	private ChunkPosition chunkPosition;
	
	private BlockSand fallingBlock;
	
	/**
	 * Create a {@link BlockFallEvent}
	 * @param world - {@link World} that the event is happening  in
	 * @param fallingBlock - {@link BlockSand} that is falling. Note: BlockSand is any type of falling block
	 * @param chunkPosition - {@link ChunkPosition} it wants to fall to
	 */
	public BlockFallEvent(World world, BlockSand fallingBlock, ChunkPosition chunkPosition) {
	
		this.world = world;
		this.fallingBlock = fallingBlock;
		this.chunkPosition = chunkPosition;
		
	}
	
	/**
	 * Get the {@link ChunkPosition} the {@link BlockSand} wants to fall to
	 * @return - {@link ChunkPosition} instance
	 */
	public ChunkPosition getChunkPosition() {
	
		return chunkPosition;
	}
	
	/**
	 * Get the {@link BlockSand} that wants to fall
	 * @return - {@link BlockSand} instance
	 */
	public BlockSand getFallingBlock() {
	
		return fallingBlock;
	}
	
	/**
	 * Get the {@link World} this is happening in
	 * @return - {@link World} instance
	 */
	public World getWorld() {
	
		return world;
	}
	
}
