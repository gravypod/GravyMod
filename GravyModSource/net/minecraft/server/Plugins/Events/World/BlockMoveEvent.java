package net.minecraft.server.Plugins.Events.World;

import net.minecraft.server.Plugins.Events.Event;
import net.minecraft.src.Block;
import net.minecraft.src.BlockDragonEgg;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.World;

/**
 * Block move event is called when a {@link Block} moves. Ex: {@link BlockDragonEgg}
 * Note: this is only used in {@link BlockDragonEgg} currently
 * @author gravypod
 *
 */
public class BlockMoveEvent extends Event {
	
	private Block from;
	
	private ChunkPosition to;
	
	/**
	 * Create a {@link BlockMoveEvent}
	 * @param world - The {@link World} that is is happening in
	 * @param from - {@link Block} that is moving
	 * @param to - {@link ChunkPosition} of where it is going
	 */
	public BlockMoveEvent(World world, Block from, ChunkPosition to) {
	
		this.from = from;
		this.to = to;
	}
	
	/**
	 * Block that wants to move
	 * @return - {@link Block} instance
	 */
	public Block getFrom() {
	
		return from;
	}
	
	/**
	 * Where the {@link Block} wants to move
	 * @return - {@link ChunkPosition} instance
	 */
	public ChunkPosition getTo() {
	
		return to;
	}
	
	/**
	 * Set where the block wants to go to
	 * @param to - {@link ChunkPosition} of where to send the block
	 */
	public void setTo(ChunkPosition to) {
	
		this.to = to;
	}
	
}
